package com.example.recruitmentapp.service.impl;

import com.example.recruitmentapp.dto.RecruitmentInitializationResponse;
import com.example.recruitmentapp.dto.RecruitmentRequest;
import com.example.recruitmentapp.dto.RecruitmentResponse;
import com.example.recruitmentapp.entity.Profile;
import com.example.recruitmentapp.entity.ProfileQuestionTemplate;
import com.example.recruitmentapp.entity.ProfileStageScoreTemplate;
import com.example.recruitmentapp.entity.ProfileStageTemplate;
import com.example.recruitmentapp.entity.Recruitment;
import com.example.recruitmentapp.entity.RecruitmentQuestion;
import com.example.recruitmentapp.entity.RecruitmentStage;
import com.example.recruitmentapp.entity.RecruitmentStageScoreTemplate;
import com.example.recruitmentapp.exception.BusinessConflictException;
import com.example.recruitmentapp.exception.ResourceNotFoundException;
import com.example.recruitmentapp.mapper.RecruitmentMapper;
import com.example.recruitmentapp.repository.ProfileQuestionTemplateRepository;
import com.example.recruitmentapp.repository.ProfileRepository;
import com.example.recruitmentapp.repository.ProfileStageScoreTemplateRepository;
import com.example.recruitmentapp.repository.ProfileStageTemplateRepository;
import com.example.recruitmentapp.repository.RecruitmentQuestionRepository;
import com.example.recruitmentapp.repository.RecruitmentRepository;
import com.example.recruitmentapp.repository.RecruitmentStageRepository;
import com.example.recruitmentapp.repository.RecruitmentStageScoreTemplateRepository;
import com.example.recruitmentapp.service.RecruitmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecruitmentServiceImpl implements RecruitmentService {

    private final RecruitmentRepository repository;
    private final RecruitmentMapper mapper;
    private final ProfileRepository profileRepository;
    private final ProfileStageTemplateRepository profileStageTemplateRepository;
    private final ProfileQuestionTemplateRepository profileQuestionTemplateRepository;
    private final ProfileStageScoreTemplateRepository profileStageScoreTemplateRepository;
    private final RecruitmentStageRepository recruitmentStageRepository;
    private final RecruitmentQuestionRepository recruitmentQuestionRepository;
    private final RecruitmentStageScoreTemplateRepository recruitmentStageScoreTemplateRepository;

    @Override
    public RecruitmentResponse create(RecruitmentRequest request) {
        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + request.getProfileId()));
        Recruitment entity = mapper.toEntity(request, profile);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RecruitmentResponse getById(Integer id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + id)));
    }

    @Override
    public List<RecruitmentResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public RecruitmentResponse update(Integer id, RecruitmentRequest request) {
        Recruitment existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + id));
        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found with id: " + request.getProfileId()));
        mapper.updateEntity(existing, request, profile);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recruitment not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public RecruitmentInitializationResponse initializeFromProfileTemplates(Integer id) {
        Recruitment recruitment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recruitment not found with id: " + id));

        List<RecruitmentStage> existingStages = recruitmentStageRepository.findByRecruitmentIdOrderByDisplayOrder(id);
        if (!existingStages.isEmpty()) {
            int existingQuestions = existingStages.stream()
                    .map(stage -> recruitmentQuestionRepository.findByRecruitmentStageIdOrderByDisplayOrder(stage.getId()).size())
                    .reduce(0, Integer::sum);
            int existingScoreTemplates = existingStages.stream()
                    .map(stage -> recruitmentStageScoreTemplateRepository.findByStageIdOrderByDisplayOrder(stage.getId()).size())
                    .reduce(0, Integer::sum);

            return RecruitmentInitializationResponse.builder()
                    .recruitmentId(id)
                    .stagesCreated(existingStages.size())
                    .questionsCreated(existingQuestions)
                    .scoreTemplatesCreated(existingScoreTemplates)
                    .initialized(false)
                    .message("Recruitment already initialized. No changes were applied to avoid data conflicts.")
                    .build();
        }

        int stagesCount = 0;
        int questionsCount = 0;
        int scoreTemplatesCount = 0;

        List<ProfileStageTemplate> stageTemplates = profileStageTemplateRepository
                .findByProfileIdOrderByDisplayOrder(recruitment.getProfile().getId());
        if (stageTemplates.isEmpty()) {
            throw new BusinessConflictException("Cannot initialize recruitment: profile has no stage templates.");
        }

        for (ProfileStageTemplate stageTemplate : stageTemplates) {
            RecruitmentStage stage = RecruitmentStage.builder()
                    .recruitment(recruitment)
                    .profileStageTemplate(stageTemplate)
                    .displayOrder(stageTemplate.getDisplayOrder())
                    .name(stageTemplate.getName())
                    .build();
            RecruitmentStage savedStage = recruitmentStageRepository.save(stage);
            stagesCount++;

            List<ProfileQuestionTemplate> questionTemplates = profileQuestionTemplateRepository
                    .findByProfileStageTemplateIdOrderByDisplayOrder(stageTemplate.getId());
            for (ProfileQuestionTemplate questionTemplate : questionTemplates) {
                RecruitmentQuestion question = RecruitmentQuestion.builder()
                        .recruitmentStage(savedStage)
                        .profileQuestionTemplate(questionTemplate)
                        .question(questionTemplate.getQuestion())
                        .displayOrder(questionTemplate.getDisplayOrder())
                        .questionType(questionTemplate.getQuestionType())
                        .isRequired(questionTemplate.getIsRequired())
                        .build();
                recruitmentQuestionRepository.save(question);
                questionsCount++;
            }

            List<ProfileStageScoreTemplate> scoreTemplates = profileStageScoreTemplateRepository
                    .findByProfileStageTemplateIdOrderByDisplayOrder(stageTemplate.getId());
            for (ProfileStageScoreTemplate scoreTemplate : scoreTemplates) {
                RecruitmentStageScoreTemplate recruitmentScoreTemplate = RecruitmentStageScoreTemplate.builder()
                        .stage(savedStage)
                        .profileStageScoreTemplate(scoreTemplate)
                        .label(scoreTemplate.getLabel())
                        .weight(scoreTemplate.getWeight())
                        .displayOrder(scoreTemplate.getDisplayOrder())
                        .build();
                recruitmentStageScoreTemplateRepository.save(recruitmentScoreTemplate);
                scoreTemplatesCount++;
            }
        }

        return RecruitmentInitializationResponse.builder()
                .recruitmentId(id)
                .stagesCreated(stagesCount)
                .questionsCreated(questionsCount)
                .scoreTemplatesCreated(scoreTemplatesCount)
                .initialized(true)
                .message("Recruitment initialized from profile templates.")
                .build();
    }
}

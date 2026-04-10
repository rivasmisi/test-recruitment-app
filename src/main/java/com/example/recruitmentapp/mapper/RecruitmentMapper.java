package com.example.recruitmentapp.mapper;

import com.example.recruitmentapp.dto.RecruitmentRequest;
import com.example.recruitmentapp.dto.RecruitmentResponse;
import com.example.recruitmentapp.entity.Profile;
import com.example.recruitmentapp.entity.Recruitment;
import org.springframework.stereotype.Component;

@Component
public class RecruitmentMapper {

    public Recruitment toEntity(RecruitmentRequest request, Profile profile) {
        Recruitment entity = new Recruitment();
        entity.setProfile(profile);
        entity.setStatus(request.getStatus());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        entity.setPositionsNeeded(request.getPositionsNeeded());
        entity.setApplicants(request.getApplicants());
        entity.setSalary(request.getSalary());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public void updateEntity(Recruitment entity, RecruitmentRequest request, Profile profile) {
        entity.setProfile(profile);
        entity.setStatus(request.getStatus());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        entity.setPositionsNeeded(request.getPositionsNeeded());
        entity.setApplicants(request.getApplicants());
        entity.setSalary(request.getSalary());
        entity.setDescription(request.getDescription());
    }

    public RecruitmentResponse toResponse(Recruitment entity) {
        return RecruitmentResponse.builder()
                .id(entity.getId())
                .profileId(entity.getProfile() != null ? entity.getProfile().getId() : null)
                .status(entity.getStatus())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .positionsNeeded(entity.getPositionsNeeded())
                .applicants(entity.getApplicants())
                .salary(entity.getSalary())
                .description(entity.getDescription())
                .build();
    }
}

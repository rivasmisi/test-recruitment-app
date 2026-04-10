package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.ProfileQuestionTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileQuestionTemplateRepository extends JpaRepository<ProfileQuestionTemplate, Integer> {
    List<ProfileQuestionTemplate> findByProfileStageTemplateIdOrderByDisplayOrder(Integer profileStageTemplateId);
}

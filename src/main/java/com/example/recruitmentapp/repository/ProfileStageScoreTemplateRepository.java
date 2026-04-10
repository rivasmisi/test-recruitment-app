package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.ProfileStageScoreTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileStageScoreTemplateRepository extends JpaRepository<ProfileStageScoreTemplate, Integer> {
    List<ProfileStageScoreTemplate> findByProfileStageTemplateIdOrderByDisplayOrder(Integer profileStageTemplateId);
}

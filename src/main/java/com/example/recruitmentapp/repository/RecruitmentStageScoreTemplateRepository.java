package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.RecruitmentStageScoreTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentStageScoreTemplateRepository extends JpaRepository<RecruitmentStageScoreTemplate, Integer> {
    List<RecruitmentStageScoreTemplate> findByStageIdOrderByDisplayOrder(Integer stageId);
}

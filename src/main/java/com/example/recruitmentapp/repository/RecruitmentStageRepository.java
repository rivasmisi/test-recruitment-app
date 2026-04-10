package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.RecruitmentStage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentStageRepository extends JpaRepository<RecruitmentStage, Integer> {
    List<RecruitmentStage> findByRecruitmentIdOrderByDisplayOrder(Integer recruitmentId);
}

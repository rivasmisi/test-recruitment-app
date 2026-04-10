package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.RecruitmentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentQuestionRepository extends JpaRepository<RecruitmentQuestion, Integer> {
    List<RecruitmentQuestion> findByRecruitmentStageIdOrderByDisplayOrder(Integer recruitmentStageId);

    void deleteByRecruitmentStageId(Integer recruitmentStageId);
}

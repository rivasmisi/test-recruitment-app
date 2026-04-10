package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.RecruitmentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentQuestionRepository extends JpaRepository<RecruitmentQuestion, Integer> {
}

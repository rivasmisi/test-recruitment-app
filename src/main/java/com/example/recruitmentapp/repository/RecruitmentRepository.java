package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {
}

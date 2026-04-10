package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.ApplicationScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationScoreRepository extends JpaRepository<ApplicationScore, Integer> {
}

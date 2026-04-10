package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.ProfileStageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileStageTemplateRepository extends JpaRepository<ProfileStageTemplate, Integer> {
    List<ProfileStageTemplate> findByProfileIdOrderByDisplayOrder(Integer profileId);
}

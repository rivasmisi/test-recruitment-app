package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}

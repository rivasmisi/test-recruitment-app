package com.example.recruitmentapp.repository;

import com.example.recruitmentapp.entity.ApplicationFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationFileRepository extends JpaRepository<ApplicationFile, Integer> {
}

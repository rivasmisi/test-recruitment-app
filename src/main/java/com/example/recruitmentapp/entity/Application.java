package com.example.recruitmentapp.entity;

import com.example.recruitmentapp.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitment_id", nullable = false)
    private Recruitment recruitment;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "application_date", nullable = false)
    private LocalDateTime applicationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_stage_id")
    private RecruitmentStage currentStage;

    @Column(name = "preliminary_score", precision = 10, scale = 2)
    private BigDecimal preliminaryScore;

    @Column(name = "global_score", precision = 10, scale = 2)
    private BigDecimal globalScore;

    @Column(name = "application_duration_days")
    private Integer applicationDurationDays;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = ApplicationStatus.SUBMITTED;
        }
        if (applicationDate == null) {
            applicationDate = LocalDateTime.now();
        }
    }
}

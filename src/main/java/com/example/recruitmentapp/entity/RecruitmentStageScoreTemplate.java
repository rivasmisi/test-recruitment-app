package com.example.recruitmentapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "recruitment_stage_score_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentStageScoreTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id", nullable = false)
    private RecruitmentStage stage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_stage_score_template_id")
    private ProfileStageScoreTemplate profileStageScoreTemplate;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal weight;

    @Column(name = "order", nullable = false)
    private Integer displayOrder;
}

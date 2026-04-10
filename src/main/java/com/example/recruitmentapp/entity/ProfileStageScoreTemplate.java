package com.example.recruitmentapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "profile_stage_score_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileStageScoreTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_stage_template_id", nullable = false)
    private ProfileStageTemplate profileStageTemplate;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal weight;

    @Column(name = "order", nullable = false)
    private Integer displayOrder;
}

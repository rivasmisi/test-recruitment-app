package com.example.recruitmentapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruitment_stages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitment_id", nullable = false)
    private Recruitment recruitment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_stage_template_id")
    private ProfileStageTemplate profileStageTemplate;

    @Column(name = "order", nullable = false)
    private Integer displayOrder;

    @Column(nullable = false)
    private String name;
}

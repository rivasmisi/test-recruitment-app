package com.example.recruitmentapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profile_stage_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileStageTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "order", nullable = false)
    private Integer displayOrder;

    @Column(nullable = false)
    private String name;
}

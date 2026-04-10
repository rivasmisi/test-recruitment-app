package com.example.recruitmentapp.entity;

import com.example.recruitmentapp.enums.RecruitmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recruitment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecruitmentStatus status;

    @Column(name = "start")
    private LocalDateTime startDate;

    @Column(name = "end")
    private LocalDateTime endDate;

    @Column(name = "positions_needed", nullable = false)
    private Integer positionsNeeded;

    @Column(nullable = false)
    private Integer applicants;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal salary;

    private String description;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = RecruitmentStatus.O;
        }
        if (startDate == null) {
            startDate = LocalDateTime.now();
        }
    }
}

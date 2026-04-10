package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.RecruitmentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentResponse {

    private Integer id;

    private Integer profileId;

    private RecruitmentStatus status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer positionsNeeded;

    private Integer applicants;

    private BigDecimal salary;

    private String description;
}

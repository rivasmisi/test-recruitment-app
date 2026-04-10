package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.RecruitmentStatus;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentRequest {

    @NotNull
    private Integer profileId;

    @NotNull
    private RecruitmentStatus status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @NotNull
    private Integer positionsNeeded;

    @NotNull
    private Integer applicants;

    @NotNull
    private BigDecimal salary;

    private String description;
}

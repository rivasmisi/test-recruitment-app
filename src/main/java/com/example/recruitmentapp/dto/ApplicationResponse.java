package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.ApplicationStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationResponse {

    private Integer id;

    private Integer recruitmentId;

    private Integer currentStageId;

    private String fullName;

    private String email;

    private String phoneNumber;

    private LocalDateTime applicationDate;

    private ApplicationStatus status;

    private BigDecimal preliminaryScore;

    private BigDecimal globalScore;

    private Integer applicationDurationDays;
}

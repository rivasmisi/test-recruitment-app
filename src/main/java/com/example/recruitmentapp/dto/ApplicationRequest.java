package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.ApplicationStatus;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRequest {

    @NotNull
    private Integer recruitmentId;

    private Integer currentStageId;

    @NotBlank
    private String fullName;

    @NotBlank @Email
    private String email;

    private String phoneNumber;

    @NotNull
    private LocalDateTime applicationDate;

    @NotNull
    private ApplicationStatus status;

    private BigDecimal preliminaryScore;

    private BigDecimal globalScore;

    private Integer applicationDurationDays;
}

package com.example.recruitmentapp.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentStageScoreTemplateRequest {

    @NotNull
    private Integer stageId;

    private Integer profileStageScoreTemplateId;

    @NotBlank
    private String label;

    @NotNull
    private BigDecimal weight;

    @NotNull
    private Integer displayOrder;
}

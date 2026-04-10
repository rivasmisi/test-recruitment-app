package com.example.recruitmentapp.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileStageScoreTemplateRequest {

    @NotNull
    private Integer profileStageTemplateId;

    @NotBlank
    private String label;

    @NotNull
    private BigDecimal weight;

    @NotNull
    private Integer displayOrder;
}

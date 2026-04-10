package com.example.recruitmentapp.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationScoreRequest {

    @NotNull
    private Integer applicationId;

    @NotNull
    private Integer stageScoreTemplateId;

    @NotNull
    private BigDecimal score;

    private String comments;
}

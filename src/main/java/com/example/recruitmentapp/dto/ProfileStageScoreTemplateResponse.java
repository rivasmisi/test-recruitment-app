package com.example.recruitmentapp.dto;

import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileStageScoreTemplateResponse {

    private Integer id;

    private Integer profileStageTemplateId;

    private String label;

    private BigDecimal weight;

    private Integer displayOrder;
}

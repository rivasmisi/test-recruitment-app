package com.example.recruitmentapp.dto;

import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentStageScoreTemplateResponse {

    private Integer id;

    private Integer stageId;

    private Integer profileStageScoreTemplateId;

    private String label;

    private BigDecimal weight;

    private Integer displayOrder;
}

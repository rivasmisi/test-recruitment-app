package com.example.recruitmentapp.dto;

import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationScoreResponse {

    private Integer id;

    private Integer applicationId;

    private Integer stageScoreTemplateId;

    private BigDecimal score;

    private String comments;
}

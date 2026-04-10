package com.example.recruitmentapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentInitializationResponse {
    private Integer recruitmentId;
    private Integer stagesCreated;
    private Integer questionsCreated;
    private Integer scoreTemplatesCreated;
}

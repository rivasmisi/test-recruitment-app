package com.example.recruitmentapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentStageResponse {

    private Integer id;

    private Integer recruitmentId;

    private Integer profileStageTemplateId;

    private Integer displayOrder;

    private String name;
}

package com.example.recruitmentapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileStageTemplateResponse {

    private Integer id;

    private Integer profileId;

    private Integer displayOrder;

    private String name;
}

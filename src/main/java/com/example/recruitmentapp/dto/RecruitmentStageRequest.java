package com.example.recruitmentapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentStageRequest {

    @NotNull
    private Integer recruitmentId;

    private Integer profileStageTemplateId;

    @NotNull
    private Integer displayOrder;

    @NotBlank
    private String name;
}

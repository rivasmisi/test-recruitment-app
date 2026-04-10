package com.example.recruitmentapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileStageTemplateRequest {

    @NotNull
    private Integer profileId;

    @NotNull
    private Integer displayOrder;

    @NotBlank
    private String name;
}

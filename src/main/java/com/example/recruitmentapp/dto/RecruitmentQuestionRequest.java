package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.QuestionsType;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentQuestionRequest {

    @NotNull
    private Integer recruitmentStageId;

    private Integer profileQuestionTemplateId;

    @NotBlank
    private String question;

    @NotNull
    private Integer displayOrder;

    @NotNull
    private QuestionsType questionType;

    @NotNull
    private Boolean isRequired;
}

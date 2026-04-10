package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.QuestionsType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentQuestionResponse {

    private Integer id;

    private Integer recruitmentStageId;

    private Integer profileQuestionTemplateId;

    private String question;

    private Integer displayOrder;

    private QuestionsType questionType;

    private Boolean isRequired;
}

package com.example.recruitmentapp.dto;

import com.example.recruitmentapp.enums.QuestionsType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileQuestionTemplateResponse {

    private Integer id;

    private Integer profileStageTemplateId;

    private String question;

    private Integer displayOrder;

    private QuestionsType questionType;

    private Boolean isRequired;
}

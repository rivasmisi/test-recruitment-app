package com.example.recruitmentapp.entity;

import com.example.recruitmentapp.enums.QuestionsType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruitment_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitment_stage_id", nullable = false)
    private RecruitmentStage recruitmentStage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_question_template_id")
    private ProfileQuestionTemplate profileQuestionTemplate;

    @Column(nullable = false)
    private String question;

    @Column(name = "order", nullable = false)
    private Integer displayOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", nullable = false)
    private QuestionsType questionType;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired;

    @PrePersist
    public void prePersist() {
        if (isRequired == null) {
            isRequired = true;
        }
    }
}

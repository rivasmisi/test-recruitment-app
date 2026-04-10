package com.example.recruitmentapp.entity;

import com.example.recruitmentapp.enums.QuestionsType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profile_question_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileQuestionTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_stage_template_id", nullable = false)
    private ProfileStageTemplate profileStageTemplate;

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

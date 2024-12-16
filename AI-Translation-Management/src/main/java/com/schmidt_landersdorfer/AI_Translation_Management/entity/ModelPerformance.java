package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "model_performance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metricName;
    private float value;
    private Date evaluationDate;
    private String reviewComment;

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "translation_model_id")
    private TranslationModel translationModel;
}

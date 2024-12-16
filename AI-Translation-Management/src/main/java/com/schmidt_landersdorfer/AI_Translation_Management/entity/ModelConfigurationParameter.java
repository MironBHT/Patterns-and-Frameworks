package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "model_configuration_parameters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelConfigurationParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parameterName;
    private int parameterValue;
    private String description;

    @ManyToOne
    @JoinColumn(name = "translation_model_id")
    private TranslationModel translationModel;
}

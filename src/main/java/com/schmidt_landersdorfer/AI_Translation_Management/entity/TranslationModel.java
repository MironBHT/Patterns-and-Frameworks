package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "translation_models")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TranslationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String description;
    private String version;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "external_service_id")
    private ExternalTranslationService externalService;

    @OneToMany(mappedBy = "translationModel", cascade = CascadeType.ALL)
    private List<UserFeedback> feedbacks;

    @OneToMany(mappedBy = "translationModel", cascade = CascadeType.ALL)
    private List<Translation> translations;

    @OneToMany(mappedBy = "translationModel", cascade = CascadeType.ALL)
    private List<ModelPerformance> performances;

    @OneToMany(mappedBy = "translationModel", cascade = CascadeType.ALL)
    private List<ModelConfigurationParameter> configurationParameters;
}

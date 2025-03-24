package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "text_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TextData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataSetName;
    private String sourceLanguage;
    private int fileSize;
    private String description;

    @ManyToOne
    @JoinColumn(name = "data_provider_id")
    private DataProvider dataProvider;  // Wieder aktivieren!

    @ManyToOne
    @JoinColumn(name = "translation_model_id")
    private TranslationModel translationModel;
}


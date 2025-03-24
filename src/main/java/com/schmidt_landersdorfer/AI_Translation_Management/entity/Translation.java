package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "translations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceText;
    private String translatedText;
    private String sourceLanguage;
    private String targetLanguage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "translation_model_id")
    private TranslationModel translationModel;

}


package com.schmidt_landersdorfer.AI_Translation_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslationDTO {
    private String sourceText;
    private String translatedText;
    private String sourceLanguage;
    private String targetLanguage;
    private Long fileSize;
}


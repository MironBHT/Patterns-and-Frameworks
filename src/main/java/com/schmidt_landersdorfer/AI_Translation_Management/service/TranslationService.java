package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.dto.TranslationDTO;
import com.schmidt_landersdorfer.AI_Translation_Management.entity.Translation;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    public Translation createTranslation(TranslationDTO translationDTO) {
        Translation translation = new Translation();
        translation.setSourceText(translationDTO.getSourceText());
        translation.setTranslatedText(translationDTO.getTranslatedText());
        translation.setSourceLanguage(translationDTO.getSourceLanguage());
        translation.setTargetLanguage(translationDTO.getTargetLanguage());
        return translationRepository.save(translation);
    }

    public List<Translation> getAllTranslations() {
        return translationRepository.findAll();
    }

    public Optional<Translation> getTranslationById(Long id) {
        return translationRepository.findById(id);
    }
}

package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.TranslationModel;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.TranslationModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationModelService {

    private final TranslationModelRepository translationModelRepository;

    @Autowired
    public TranslationModelService(TranslationModelRepository translationModelRepository) {
        this.translationModelRepository = translationModelRepository;
    }

    public List<TranslationModel> getAllTranslationModels() {
        return translationModelRepository.findAll();
    }

    public Optional<TranslationModel> getTranslationModelById(Long id) {
        return translationModelRepository.findById(id);
    }

    public TranslationModel createTranslationModel(TranslationModel translationModel) {
        return translationModelRepository.save(translationModel);
    }

    public TranslationModel updateTranslationModel(Long id, TranslationModel translationModel) {
        if (translationModelRepository.existsById(id)) {
            translationModel.setId(id);
            return translationModelRepository.save(translationModel);
        } else {
            return null;
        }
    }

    public boolean deleteTranslationModel(Long id) {
        if (translationModelRepository.existsById(id)) {
            translationModelRepository.deleteById(id);
            return true;  // Erfolgreiches Löschen
        } else {
            return false;
        }
    }
}

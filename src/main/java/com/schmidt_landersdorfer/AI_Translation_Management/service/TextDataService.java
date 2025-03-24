package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.TextData;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.TextDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TextDataService {

    private final TextDataRepository textDataRepository;

    @Autowired
    public TextDataService(TextDataRepository textDataRepository) {
        this.textDataRepository = textDataRepository;
    }

    public TextData createTextData(TextData textData) {
        return textDataRepository.save(textData);
    }

    public List<TextData> getAllTextData() {
        return textDataRepository.findAll();
    }

    public TextData getTextDataById(Long id) {
        Optional<TextData> textData = textDataRepository.findById(id);
        return textData.orElse(null);
    }

    public TextData updateTextData(Long id, TextData updatedTextData) {
        if (textDataRepository.existsById(id)) {
            updatedTextData.setId(id);
            return textDataRepository.save(updatedTextData);
        }
        return null;
    }

    public void deleteTextData(Long id) {
        if (textDataRepository.existsById(id)) {
            textDataRepository.deleteById(id);
        }
    }
}

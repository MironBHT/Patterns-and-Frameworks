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

    // Create a new TextData entry
    public TextData createTextData(TextData textData) {
        return textDataRepository.save(textData);  // Saves the TextData entity to the database
    }

    // Retrieve all TextData entries
    public List<TextData> getAllTextData() {
        return textDataRepository.findAll();  // Retrieves all TextData entries
    }

    // Retrieve a TextData entry by ID
    public TextData getTextDataById(Long id) {
        Optional<TextData> textData = textDataRepository.findById(id);
        return textData.orElse(null);  // Returns the TextData if found, otherwise null
    }

    // Update a TextData entry
    public TextData updateTextData(Long id, TextData updatedTextData) {
        if (textDataRepository.existsById(id)) {
            updatedTextData.setId(id);  // Ensures the ID is set for the update
            return textDataRepository.save(updatedTextData);  // Updates the TextData entity in the database
        }
        return null;  // Return null if the TextData entry doesn't exist
    }

    // Delete a TextData entry
    public void deleteTextData(Long id) {
        if (textDataRepository.existsById(id)) {
            textDataRepository.deleteById(id);  // Deletes the TextData entry from the database
        }
    }
}

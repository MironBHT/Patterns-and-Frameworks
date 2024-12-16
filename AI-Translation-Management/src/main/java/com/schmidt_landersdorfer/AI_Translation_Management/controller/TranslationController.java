package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.Translation;
import com.schmidt_landersdorfer.AI_Translation_Management.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {

    // Autowired TranslationService to use business logic
    @Autowired
    private TranslationService translationService;

    // Get all translations
    @GetMapping
    public ResponseEntity<List<Translation>> getAllTranslations() {
        List<Translation> translations = translationService.getAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    // Get a single translation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Translation> getTranslationById(@PathVariable Long id) {
        Optional<Translation> translation = translationService.getTranslationById(id);
        if (translation.isPresent()) {
            return new ResponseEntity<>(translation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new translation
    @PostMapping
    public ResponseEntity<Translation> createTranslation(@RequestBody Translation translation) {
        Translation createdTranslation = translationService.createTranslation(translation);
        return new ResponseEntity<>(createdTranslation, HttpStatus.CREATED);
    }

    // Update an existing translation
    @PutMapping("/{id}")
    public ResponseEntity<Translation> updateTranslation(@PathVariable Long id, @RequestBody Translation translation) {
        Optional<Translation> existingTranslation = translationService.getTranslationById(id);
        if (existingTranslation.isPresent()) {
            translation.setId(id); // Ensure the ID is set correctly
            Translation updatedTranslation = translationService.updateTranslation(translation);
            return new ResponseEntity<>(updatedTranslation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a translation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        Optional<Translation> translation = translationService.getTranslationById(id);
        if (translation.isPresent()) {
            translationService.deleteTranslation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

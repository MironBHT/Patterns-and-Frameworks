package com.schmidt_landersdorfer.AI_Translation_Management.controller;


import com.schmidt_landersdorfer.AI_Translation_Management.entity.TranslationModel;
import com.schmidt_landersdorfer.AI_Translation_Management.service.TranslationModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/translation-models")
public class TranslationModelController {

    private final TranslationModelService translationModelService;

    // Konstruktorinjektion für den Service
    @Autowired
    public TranslationModelController(TranslationModelService translationModelService) {
        this.translationModelService = translationModelService;
    }

    // Endpunkt, um alle Übersetzungsmodelle zu holen
    @GetMapping
    public ResponseEntity<List<TranslationModel>> getAllTranslationModels() {
        List<TranslationModel> translationModels = translationModelService.getAllTranslationModels();
        return new ResponseEntity<>(translationModels, HttpStatus.OK);
    }

    // Endpunkt, um ein Übersetzungsmodell nach ID zu holen
    @GetMapping("/{id}")
    public ResponseEntity<TranslationModel> getTranslationModelById(@PathVariable Long id) {
        Optional<TranslationModel> translationModel = translationModelService.getTranslationModelById(id);
        return translationModel.map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpunkt, um ein neues Übersetzungsmodell zu erstellen
    @PostMapping
    public ResponseEntity<TranslationModel> createTranslationModel(@RequestBody TranslationModel translationModel) {
        TranslationModel createdModel = translationModelService.createTranslationModel(translationModel);
        return new ResponseEntity<>(createdModel, HttpStatus.CREATED);
    }

    // Endpunkt, um ein Übersetzungsmodell zu aktualisieren
    @PutMapping("/{id}")
    public ResponseEntity<TranslationModel> updateTranslationModel(@PathVariable Long id, @RequestBody TranslationModel translationModel) {
        TranslationModel updatedModel = translationModelService.updateTranslationModel(id, translationModel);
        return updatedModel != null ? new ResponseEntity<>(updatedModel, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpunkt, um ein Übersetzungsmodell zu löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslationModel(@PathVariable Long id) {
        boolean isDeleted = translationModelService.deleteTranslationModel(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

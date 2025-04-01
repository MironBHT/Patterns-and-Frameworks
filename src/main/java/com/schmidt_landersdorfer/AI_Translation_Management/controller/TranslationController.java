package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.dto.TranslationDTO;
import com.schmidt_landersdorfer.AI_Translation_Management.entity.Translation;
import com.schmidt_landersdorfer.AI_Translation_Management.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @PostMapping
    public ResponseEntity<TranslationDTO> createTranslation(@RequestBody TranslationDTO translationDTO) {
        Translation translation = translationService.createTranslation(translationDTO);
        TranslationDTO responseDTO = mapToDTO(translation);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public List<TranslationDTO> getAllTranslations() {
        return translationService.getAllTranslations()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TranslationDTO> getTranslationById(@PathVariable Long id) {
        return translationService.getTranslationById(id)
                .map(translation -> ResponseEntity.ok(mapToDTO(translation)))
                .orElse(ResponseEntity.notFound().build());
    }

    private TranslationDTO mapToDTO(Translation translation) {
        return new TranslationDTO(
                translation.getSourceText(),
                translation.getTranslatedText(),
                translation.getSourceLanguage(),
                translation.getTargetLanguage(),
                0l
        );
    }
}

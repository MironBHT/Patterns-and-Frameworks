package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.TextData;
import com.schmidt_landersdorfer.AI_Translation_Management.service.TextDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/text-data")
public class TextDataController {

    private final TextDataService textDataService;

    @Autowired
    public TextDataController(TextDataService textDataService) {
        this.textDataService = textDataService;
    }

    // Create a new TextData entry
    @PostMapping
    public ResponseEntity<TextData> createTextData(@RequestBody TextData textData) {
        TextData createdTextData = textDataService.createTextData(textData);
        return ResponseEntity.ok(createdTextData);
    }

    // Retrieve all TextData entries
    @GetMapping
    public ResponseEntity<List<TextData>> getAllTextData() {
        List<TextData> textDataList = textDataService.getAllTextData();
        return ResponseEntity.ok(textDataList);
    }

    // Retrieve a single TextData entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<TextData> getTextDataById(@PathVariable Long id) {
        TextData textData = textDataService.getTextDataById(id);
        return ResponseEntity.ok(textData);
    }

    // Update a TextData entry
    @PutMapping("/{id}")
    public ResponseEntity<TextData> updateTextData(@PathVariable Long id, @RequestBody TextData updatedTextData) {
        TextData updated = textDataService.updateTextData(id, updatedTextData);
        return ResponseEntity.ok(updated);
    }

    // Delete a TextData entry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTextData(@PathVariable Long id) {
        textDataService.deleteTextData(id);
        return ResponseEntity.noContent().build();
    }
}

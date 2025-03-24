package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ExternalTranslationService;
import com.schmidt_landersdorfer.AI_Translation_Management.service.ExternalTranslationServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/data-providers")
@RequestMapping("/api/external-translation-services")
public class ExternalTranslationServiceController {

    private final ExternalTranslationServiceService externalTranslationServiceService;

    @Autowired
    public ExternalTranslationServiceController(ExternalTranslationServiceService externalTranslationServiceService) {
        this.externalTranslationServiceService = externalTranslationServiceService;
    }

    @GetMapping
    public ResponseEntity<List<ExternalTranslationService>> getAllExternalTranslationServices() {
        List<ExternalTranslationService> services = externalTranslationServiceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExternalTranslationService> getExternalTranslationServiceById(@PathVariable Long id) {
        ExternalTranslationService service = externalTranslationServiceService.getServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExternalTranslationService> createExternalTranslationService(
            @RequestBody ExternalTranslationService externalTranslationService) {
        ExternalTranslationService createdService = externalTranslationServiceService.createService(externalTranslationService);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExternalTranslationService> updateExternalTranslationService(
            @PathVariable Long id,
            @RequestBody ExternalTranslationService externalTranslationService) {
        ExternalTranslationService updatedService = externalTranslationServiceService.updateService(id, externalTranslationService);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExternalTranslationService(@PathVariable Long id) {
        externalTranslationServiceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

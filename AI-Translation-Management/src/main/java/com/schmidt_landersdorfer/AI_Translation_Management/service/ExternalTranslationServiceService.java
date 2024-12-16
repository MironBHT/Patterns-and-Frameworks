package com.schmidt_landersdorfer.AI_Translation_Management.service;


import com.schmidt_landersdorfer.AI_Translation_Management.entity.ExternalTranslationService;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.ExternalTranslationServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExternalTranslationServiceService {

    private final ExternalTranslationServiceRepository repository;

    @Autowired
    public ExternalTranslationServiceService(ExternalTranslationServiceRepository repository) {
        this.repository = repository;
    }

    // Retrieve all ExternalTranslationServices
    public List<ExternalTranslationService> getAllServices() {
        return repository.findAll();
    }

    // Retrieve a single ExternalTranslationService by ID
    public ExternalTranslationService getServiceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExternalTranslationService not found with ID: " + id));
    }

    // Create a new ExternalTranslationService
    public ExternalTranslationService createService(ExternalTranslationService externalTranslationService) {
        return repository.save(externalTranslationService);
    }

    // Update an existing ExternalTranslationService
    public ExternalTranslationService updateService(Long id, ExternalTranslationService updatedService) {
        // Check if the service exists
        Optional<ExternalTranslationService> existingServiceOpt = repository.findById(id);
        if (existingServiceOpt.isEmpty()) {
            throw new RuntimeException("ExternalTranslationService not found with ID: " + id);
        }

        // Update fields
        ExternalTranslationService existingService = existingServiceOpt.get();
        existingService.setServiceName(updatedService.getServiceName());
        existingService.setApiEndpoint(updatedService.getApiEndpoint());
        existingService.setContactInformation(updatedService.getContactInformation());

        return repository.save(existingService);
    }

    // Delete an ExternalTranslationService by ID
    public void deleteService(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ExternalTranslationService not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}

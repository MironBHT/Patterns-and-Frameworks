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

    public List<ExternalTranslationService> getAllServices() {
        return repository.findAll();
    }

    public ExternalTranslationService getServiceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExternalTranslationService not found with ID: " + id));
    }

    public ExternalTranslationService createService(ExternalTranslationService externalTranslationService) {
        return repository.save(externalTranslationService);
    }

    public ExternalTranslationService updateService(Long id, ExternalTranslationService updatedService) {

        Optional<ExternalTranslationService> existingServiceOpt = repository.findById(id);
        if (existingServiceOpt.isEmpty()) {
            throw new RuntimeException("ExternalTranslationService not found with ID: " + id);
        }

        ExternalTranslationService existingService = existingServiceOpt.get();
        existingService.setServiceName(updatedService.getServiceName());
        existingService.setApiEndpoint(updatedService.getApiEndpoint());
        existingService.setContactInformation(updatedService.getContactInformation());

        return repository.save(existingService);
    }

    public void deleteService(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ExternalTranslationService not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}

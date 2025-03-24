package com.schmidt_landersdorfer.AI_Translation_Management;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ExternalTranslationService;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.ExternalTranslationServiceRepository;
import com.schmidt_landersdorfer.AI_Translation_Management.service.DataProviderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ExternalTranslationServiceRepository externalTranslationServiceRepository;
    private final DataProviderService dataProviderService;

    public DataInitializer(ExternalTranslationServiceRepository externalTranslationServiceRepository,
                           DataProviderService dataProviderService) {
        this.externalTranslationServiceRepository = externalTranslationServiceRepository;
        this.dataProviderService = dataProviderService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Erstelle einen ExternalTranslationService, falls noch keiner existiert.
        if (externalTranslationServiceRepository.count() == 0) {
            ExternalTranslationService externalService = new ExternalTranslationService();
            externalService.setServiceName("Standard Service");
            externalTranslationServiceRepository.save(externalService);
        }
    }
}



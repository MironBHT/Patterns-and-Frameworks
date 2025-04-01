package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.DataProvider;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.DataProviderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DataProviderService {

    private final DataProviderRepository dataProviderRepository;

    @Autowired
    public DataProviderService(DataProviderRepository dataProviderRepository) {
        this.dataProviderRepository = dataProviderRepository;
    }

    public List<DataProvider> getAllDataProviders() {
        return dataProviderRepository.findAll();
    }

    public Optional<DataProvider> getDataProviderById(Long id) {
        return dataProviderRepository.findById(id);
    }

    public DataProvider createDataProvider(DataProvider dataProvider) {
        return dataProviderRepository.save(dataProvider);
    }

    @Transactional
    public DataProvider updateDataProvider(Long id, DataProvider updatedDataProvider) {
        if (!dataProviderRepository.existsById(id)) {
            throw new EntityNotFoundException("DataProvider mit ID " + id + " nicht gefunden.");
        }
        updatedDataProvider.setId(id);
        return dataProviderRepository.save(updatedDataProvider);
    }

    @Transactional
    public void deleteDataProvider(Long id) {
        if (!dataProviderRepository.existsById(id)) {
            throw new EntityNotFoundException("DataProvider mit ID " + id + " nicht gefunden.");
        }
        dataProviderRepository.deleteById(id);
    }
}




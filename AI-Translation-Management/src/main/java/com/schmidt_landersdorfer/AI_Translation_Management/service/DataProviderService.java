//package com.schmidt_landersdorfer.AI_Translation_Management.service;
//
//import com.schmidt_landersdorfer.AI_Translation_Management.entity.DataProvider;
//import com.schmidt_landersdorfer.AI_Translation_Management.repository.DataProviderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DataProviderService {
//
//
//    private final DataProviderRepository dataProviderRepository;
//
//    @Autowired
//    public DataProviderService(DataProviderRepository dataProviderRepository) {
//        this.dataProviderRepository = dataProviderRepository;
//    }
//
//    public List<DataProvider> getAllDataProviders() {
//        return dataProviderRepository.findAll();
//    }
//
//    public Optional<DataProvider> getDataProviderById(Long id) {
//        return dataProviderRepository.findById(id);
//    }
//
//    public DataProvider createDataProvider(DataProvider dataProvider) {
//        return dataProviderRepository.save(dataProvider);
//    }
//
//    public DataProvider updateDataProvider(Long id, DataProvider updatedDataProvider) {
//        if (dataProviderRepository.existsById(id)) {
//            updatedDataProvider.setId(id);
//            return dataProviderRepository.save(updatedDataProvider);
//        }
//        return null;
//    }
//
//    public void deleteDataProvider(Long id) {
//        dataProviderRepository.deleteById(id);
//    }
//}



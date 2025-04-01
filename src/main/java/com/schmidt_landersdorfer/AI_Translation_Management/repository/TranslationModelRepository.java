package com.schmidt_landersdorfer.AI_Translation_Management.repository;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.TranslationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface TranslationModelRepository extends JpaRepository<TranslationModel, Long> {

    Optional<TranslationModel> findById(Long id);

    List<TranslationModel> findAll();

//    List<TranslationModel> findByModelName(String modelName);
//
//    List<TranslationModel> findByExternalTranslationServiceId(Long serviceId);
//
//    List<TranslationModel> findAllByTranslationModelId(Long modelId);
//
//    List<TranslationModel> findByCreationDateBetween(java.util.Date startDate, java.util.Date endDate);
//
//    List<TranslationModel> findByPerformanceMetrics_ValueGreaterThanEqual(Float value);
}


package com.schmidt_landersdorfer.AI_Translation_Management.repository;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.TextData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextDataRepository extends JpaRepository<TextData, Long> {

    List<TextData> findByDataSetName(String dataSetName);

    List<TextData> findBySourceLanguage(String sourceLanguage);

    List<TextData> findAllByTranslationModelId(Long modelId);
}

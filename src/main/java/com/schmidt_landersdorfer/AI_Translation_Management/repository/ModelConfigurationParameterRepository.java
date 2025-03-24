package com.schmidt_landersdorfer.AI_Translation_Management.repository;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ModelConfigurationParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelConfigurationParameterRepository extends JpaRepository<ModelConfigurationParameter, Long> {

    //List<ModelConfigurationParameter> findByModelId(Long modelId);
    List<ModelConfigurationParameter> findByTranslationModelId(Long modelId);
    List<ModelConfigurationParameter> findAllByTranslationModelId(Long modelId);
}

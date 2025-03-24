package com.schmidt_landersdorfer.AI_Translation_Management.repository;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ModelPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelPerformanceRepository extends JpaRepository<ModelPerformance, Long> {

    List<ModelPerformance> findAllByTranslationModelId(Long modelId);
}

package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ModelPerformance;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.ModelPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelPerformanceService {


    private final ModelPerformanceRepository modelPerformanceRepository;

    @Autowired
    public ModelPerformanceService(ModelPerformanceRepository modelPerformanceRepository) {
        this.modelPerformanceRepository = modelPerformanceRepository;
    }

    public ModelPerformance createModelPerformance(ModelPerformance modelPerformance) {
        return modelPerformanceRepository.save(modelPerformance);
    }

    public List<ModelPerformance> getAllModelPerformances() {
        return modelPerformanceRepository.findAll();
    }

    public Optional<ModelPerformance> getModelPerformanceById(Long id) {
        return modelPerformanceRepository.findById(id);
    }

    public ModelPerformance updateModelPerformance(Long id, ModelPerformance updatedModelPerformance) {
        if (modelPerformanceRepository.existsById(id)) {
            updatedModelPerformance.setId(id);
            return modelPerformanceRepository.save(updatedModelPerformance);
        } else {
            throw new IllegalArgumentException("ModelPerformance not found");
        }
    }

    public void deleteModelPerformance(Long id) {
        modelPerformanceRepository.deleteById(id);
    }
}

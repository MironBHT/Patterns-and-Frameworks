package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ModelPerformance;
import com.schmidt_landersdorfer.AI_Translation_Management.service.ModelPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/model-performance")
public class ModelPerformanceController {

    private final ModelPerformanceService modelPerformanceService;

    @Autowired
    public ModelPerformanceController(ModelPerformanceService modelPerformanceService) {
        this.modelPerformanceService = modelPerformanceService;
    }

    // GET all ModelPerformances
    @GetMapping
    public ResponseEntity<List<ModelPerformance>> getAllModelPerformances() {
        List<ModelPerformance> performances = modelPerformanceService.getAllModelPerformances();
        return ResponseEntity.ok(performances);
    }

    // GET ModelPerformance by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ModelPerformance>> getModelPerformanceById(@PathVariable Long id) {
        Optional<ModelPerformance> performance = modelPerformanceService.getModelPerformanceById(id);
        return ResponseEntity.ok(performance);
    }

    // POST: Create new ModelPerformance
    @PostMapping
    public ResponseEntity<ModelPerformance> createModelPerformance(@RequestBody ModelPerformance modelPerformance) {
        ModelPerformance createdPerformance = modelPerformanceService.createModelPerformance(modelPerformance);
        return ResponseEntity.ok(createdPerformance);
    }

    // PUT: Update existing ModelPerformance
    @PutMapping("/{id}")
    public ResponseEntity<ModelPerformance> updateModelPerformance(
            @PathVariable Long id,
            @RequestBody ModelPerformance modelPerformance) {
        ModelPerformance updatedPerformance = modelPerformanceService.updateModelPerformance(id, modelPerformance);
        return ResponseEntity.ok(updatedPerformance);
    }

    // DELETE: Delete ModelPerformance by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelPerformance(@PathVariable Long id) {
        modelPerformanceService.deleteModelPerformance(id);
        return ResponseEntity.noContent().build();
    }
}

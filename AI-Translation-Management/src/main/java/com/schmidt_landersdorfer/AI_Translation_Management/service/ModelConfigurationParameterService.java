package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ModelConfigurationParameter;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.ModelConfigurationParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelConfigurationParameterService {

    private final ModelConfigurationParameterRepository parameterRepository;

    @Autowired
    public ModelConfigurationParameterService(ModelConfigurationParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    // Get all configuration parameters
    public List<ModelConfigurationParameter> getAllParameters() {
        return parameterRepository.findAll();
    }

    // Get a single configuration parameter by ID
    public ModelConfigurationParameter getParameterById(Long id) {
        Optional<ModelConfigurationParameter> parameter = parameterRepository.findById(id);
        if (parameter.isEmpty()) {
            throw new IllegalArgumentException("Parameter with ID " + id + " not found.");
        }
        return parameter.get();
    }

    // Create a new configuration parameter
    public ModelConfigurationParameter createParameter(ModelConfigurationParameter parameter) {
        return parameterRepository.save(parameter);
    }

    // Update an existing configuration parameter
    public ModelConfigurationParameter updateParameter(Long id, ModelConfigurationParameter updatedParameter) {
        ModelConfigurationParameter existingParameter = getParameterById(id);

        existingParameter.setParameterName(updatedParameter.getParameterName());
        existingParameter.setParameterValue(updatedParameter.getParameterValue());
        existingParameter.setDescription(updatedParameter.getDescription());

        return parameterRepository.save(existingParameter);
    }

    // Delete a configuration parameter
    public void deleteParameter(Long id) {
        if (!parameterRepository.existsById(id)) {
            throw new IllegalArgumentException("Parameter with ID " + id + " not found.");
        }
        parameterRepository.deleteById(id);
    }
}

package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.UserFeedback;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.UserFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserFeedbackService {

    private final UserFeedbackRepository userFeedbackRepository;

    @Autowired
    public UserFeedbackService(UserFeedbackRepository userFeedbackRepository) {
        this.userFeedbackRepository = userFeedbackRepository;
    }

    public UserFeedback createUserFeedback(UserFeedback userFeedback) {
        return userFeedbackRepository.save(userFeedback);
    }

    public List<UserFeedback> getAllUserFeedback() {
        return userFeedbackRepository.findAll();
    }

    public Optional<UserFeedback> getUserFeedbackById(Long id) {
        return userFeedbackRepository.findById(id);
    }

    public UserFeedback updateUserFeedback(Long id, UserFeedback updatedFeedback) {
        if (userFeedbackRepository.existsById(id)) {
            updatedFeedback.setId(id);
            return userFeedbackRepository.save(updatedFeedback);
        }
        return null;
    }

    public boolean deleteUserFeedback(Long id) {
        if (userFeedbackRepository.existsById(id)) {
            userFeedbackRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

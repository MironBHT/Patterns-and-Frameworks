package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.UserFeedback;
import com.schmidt_landersdorfer.AI_Translation_Management.service.UserFeedbackService;
import com.schmidt_landersdorfer.AI_Translation_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class UserFeedbackController {

    private final UserFeedbackService userFeedbackService;

    @Autowired
    public UserFeedbackController(UserFeedbackService userFeedbackService) {
        this.userFeedbackService = userFeedbackService;
    }

    @PostMapping
    public ResponseEntity<UserFeedback> createFeedback(@RequestBody UserFeedback userFeedback) {
        UserFeedback createdFeedback = userFeedbackService.createUserFeedback(userFeedback);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserFeedback> getAllFeedback() {
        return userFeedbackService.getAllUserFeedback();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFeedback> getFeedbackById(@PathVariable Long id) {
        Optional<UserFeedback> feedback = userFeedbackService.getUserFeedbackById(id);
        return feedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFeedback> updateFeedback(
            @PathVariable Long id, @RequestBody UserFeedback updatedFeedback) {
        UserFeedback feedback = userFeedbackService.updateUserFeedback(id, updatedFeedback);
        return feedback != null ? ResponseEntity.ok(feedback) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        return userFeedbackService.deleteUserFeedback(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

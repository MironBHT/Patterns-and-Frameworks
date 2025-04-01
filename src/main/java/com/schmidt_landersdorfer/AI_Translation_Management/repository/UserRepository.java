package com.schmidt_landersdorfer.AI_Translation_Management.repository;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}

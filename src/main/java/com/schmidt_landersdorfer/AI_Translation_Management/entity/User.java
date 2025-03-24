package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    private Date registrationDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFeedback> feedbacks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Translation> translations;
}
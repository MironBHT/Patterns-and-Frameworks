package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "data_providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String providerName;

    @Column(nullable = false)
    private String url;

    private String providerDescription;

    @ManyToOne
    @JoinColumn(name = "external_service_id", nullable = false)
    private ExternalTranslationService externalService;

    @ToString.Exclude
    @OneToMany(mappedBy = "dataProvider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TextData> textDataList;
}






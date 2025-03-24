package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "external_translation_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExternalTranslationService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String apiEndpoint;
    private String contactInformation;

    @OneToMany(mappedBy = "externalService", cascade = CascadeType.ALL)
    private List<TranslationModel> translationModels;

//    @OneToMany(mappedBy = "externalService", cascade = CascadeType.ALL)
//    private List<DataProvider> dataProviders;
}

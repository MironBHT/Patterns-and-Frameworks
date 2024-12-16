//package com.schmidt_landersdorfer.AI_Translation_Management.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "data_providers")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class DataProvider {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String providerName;
//    private String url;
//    private String providerDescription;
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "external_service_id")
//    private ExternalTranslationService externalService;
//
//    @OneToMany(mappedBy = "dataProvider", cascade = CascadeType.ALL)
//    private List<TextData> textDataList;
//}





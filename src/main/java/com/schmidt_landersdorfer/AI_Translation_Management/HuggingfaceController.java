//package com.schmidt_landersdorfer.AI_Translation_Management;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HuggingfaceController {
//
//    private final HuggingfaceService huggingFaceService;
//
//    public HuggingfaceController(HuggingfaceService huggingFaceService) {
//        this.huggingFaceService = huggingFaceService;
//    }
//
//    @PostMapping("/api/translate")
//    public String translate(@RequestParam String text) {
//        return huggingFaceService.translateText(text);
//    }
//}
//
//

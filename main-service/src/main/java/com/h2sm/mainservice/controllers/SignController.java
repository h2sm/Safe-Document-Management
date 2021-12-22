package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/sign")
public class SignController {
    @PostMapping("/newSign")
    public void signDocument(Document doc, Assignment ass){

    }
}

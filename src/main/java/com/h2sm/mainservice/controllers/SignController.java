package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.Document;
import com.h2sm.mainservice.dtos.Sign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {
    @PostMapping("/newSign")
    public void signDocument(@RequestParam(name = "assId") Long assId){
        var sign = new Sign();
    }
}

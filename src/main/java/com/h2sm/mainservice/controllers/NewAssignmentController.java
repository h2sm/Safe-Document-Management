package com.h2sm.mainservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewAssignmentController {
    @GetMapping("/getNewHTMLAss")
    public String newHTMLAss(){
        return "newAssignment";
    }
}

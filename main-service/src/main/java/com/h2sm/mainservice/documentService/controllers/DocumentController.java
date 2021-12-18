package com.h2sm.mainservice.documentService.controllers;

import com.h2sm.mainservice.employeeService.employees.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/document")
public class DocumentController {
    @GetMapping("/download/{id}")
    public String downloadDocument(@PathVariable long id, Employee e){
        return "null";
    }
    @PostMapping("/upload")
    public String uploadDocument(){
        return "ok";
    }
    @GetMapping("/delete/{id}")
    public String deleteDocument(@PathVariable long id){
        return "ok";
    }
}

package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Worker;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocumentController {
    @RequestMapping(value = "/docs/download", method = RequestMethod.POST)
    public String downloadDocument(@RequestParam(name = "docid") long docID){
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

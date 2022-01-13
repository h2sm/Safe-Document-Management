package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Document;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.services.DocumentService;
import com.h2sm.mainservice.services.SignService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    @RequestMapping(value = "/docs/download", method = RequestMethod.GET)//из
    public Document downloadDocument(@RequestParam(name = "assID") long assId){
        return documentService.findDocByUniqueAssignmentID(assId);
    }

    @RequestMapping(value = "/docs/upload", method = RequestMethod.POST)
    @SneakyThrows
    public void uploadDocument(@RequestParam(value = "id") Long assID,
                               @RequestParam(name = "formElem") MultipartFile formElem){//в бд
        System.out.println(formElem.getName() + " " + assID);
        documentService.addDocumentToDB(formElem, assID);
    }
    @GetMapping("/delete/{id}")
    public String deleteDocument(@PathVariable long id){
        return "ok";
    }



}


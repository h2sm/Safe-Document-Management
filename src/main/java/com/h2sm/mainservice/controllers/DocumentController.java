package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Document;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.services.DocumentService;
import com.h2sm.mainservice.services.SignService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    private final SignService signService;
    @RequestMapping(value = "/docs/download", method = RequestMethod.POST)
    public String downloadDocument(@RequestParam(name = "docid") long docID){
        return "null";
    }

    @RequestMapping(value = "/docs/upload", method = RequestMethod.POST)
    @SneakyThrows
    public void uploadDocument(@RequestParam(value = "id") Long assID,
                               @RequestParam(name = "formElem") MultipartFile formElem){
        //System.out.println(formElem.getName() + " " + assID);
        documentService.addDocumentToDB(formElem);
    }
    @GetMapping("/delete/{id}")
    public String deleteDocument(@PathVariable long id){
        return "ok";
    }
}

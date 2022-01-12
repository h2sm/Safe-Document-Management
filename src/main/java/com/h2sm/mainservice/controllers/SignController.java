package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.services.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {
    private final SignService signService;
    @RequestMapping(value = "/newSign", method = RequestMethod.POST)
    public void newSign(@RequestParam(name = "assId") Long assId, @RequestParam(name = "docId") Long docID){
        signService.createSignAfterUploadingFile(assId, docID);
    }

}

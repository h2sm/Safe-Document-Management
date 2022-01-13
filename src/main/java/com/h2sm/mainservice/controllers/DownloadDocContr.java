package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

@Controller
@RequiredArgsConstructor
public class DownloadDocContr {
    private final DocumentService documentService;
    @GetMapping(value = "/docByAssId/{id}")
    public ResponseEntity<byte[]> getDocByAssId(@PathVariable(name = "id") Long assId) {
        var doc = documentService.findDocByUniqueAssignmentID(assId);
//        ByteArrayResource resource = new ByteArrayResource(doc.getData());
//        var len = doc.getData().length;
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=myDoc.png");
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(len)
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getFilename() + "\"")
                .body(doc.getData());

    }
}

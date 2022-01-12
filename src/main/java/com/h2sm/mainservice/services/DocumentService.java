package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Document;
import com.h2sm.mainservice.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class DocumentService {
    private final DocumentRepository documentRepository;
    public Document getDocumentFromDB(long id) {
        return documentRepository.getById(id);
    }
    @SneakyThrows
    public void addDocumentToDB(MultipartFile document) {
        var doc = new Document(document.getBytes());
        documentRepository.save(doc);
    }
}

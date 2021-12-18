package com.h2sm.mainservice.documentService.dto;

import com.h2sm.mainservice.documentService.documentStates.DocumentState;
import lombok.Data;

@Data
public class Document {
    private long documentID;
    private DocumentState documentState;
    private byte[] documentData;
}

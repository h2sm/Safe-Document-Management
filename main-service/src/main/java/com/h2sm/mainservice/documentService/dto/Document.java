package com.h2sm.mainservice.documentService.dto;

import com.h2sm.mainservice.documentService.documentStates.DocumentState;

public class Document {
    private long documentID;
    private DocumentState documentState;
    private byte[] documentData;
}

package com.h2sm.mainservice.documentService.dto;

import com.h2sm.mainservice.assignmentService.dto.Assignment;
import com.h2sm.mainservice.documentService.documentStates.DocumentState;
import lombok.Data;

@Data
public class Document {
    private Assignment assignmentAffiliatedToThisDocument;
    private long documentID;
    private DocumentState documentState;
    private byte[] documentData;
    private boolean isSigned = false;
}

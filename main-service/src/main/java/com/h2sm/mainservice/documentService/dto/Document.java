package com.h2sm.mainservice.documentService.dto;

import com.h2sm.mainservice.assignmentService.dto.Assignment;
import com.h2sm.mainservice.documentService.documentStates.DocumentState;
import com.h2sm.mainservice.signService.dto.Sign;
import lombok.Data;

import java.io.Serializable;

@Data
public class Document implements Serializable {
    private Assignment assignmentAffiliatedToThisDocument;
    private long documentID;
    private DocumentState documentState;
    private Sign sign;
    private byte[] documentData;
    private boolean isSigned = false;
}

package com.h2sm.mainservice.dtos;

import com.h2sm.mainservice.controllers.DocumentState;
import lombok.Data;

import java.io.Serializable;

@Data
public class Document implements Serializable {
    private Worker whoUploaded;
    private Assignment assignmentAffiliatedToThisDocument;
    private long documentID;
    private DocumentState documentState;
    private Sign sign;
    private byte[] documentData;
    private boolean isSigned = false;
}

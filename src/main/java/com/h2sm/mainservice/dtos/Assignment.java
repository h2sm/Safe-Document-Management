package com.h2sm.mainservice.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class Assignment {
    private long assignmentID;
    private Worker whoAssigned;
    private Worker whoWasAssignee;
    private Worker whoClosedAssignment;
    private String commentaryToAssignment;
    private Date dateOfAssign;
    private boolean isActive;
    private List<Document> listOfDocumentsConnectedToAssignment;

    public Assignment(Worker whoAssigned, Worker whoWasAssignee, Date dateOfAssign){
        this.whoAssigned = whoAssigned;
        this.whoWasAssignee = whoWasAssignee;
        this.dateOfAssign = dateOfAssign;
        isActive = true;
    }
}

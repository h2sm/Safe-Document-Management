package com.h2sm.mainservice.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class Assignment {
    private long assignmentID;
    private Employee whoAssigned;
    private Employee whoWasAssignee;
    private Employee whoClosedAssignment;
    private String commentaryToAssignment;
    private Date dateOfAssign;
    private boolean isActive;
    private List<Document> listOfDocumentsConnectedToAssignment;

    public Assignment(Employee whoAssigned, Employee whoWasAssignee,Date dateOfAssign){
        this.whoAssigned = whoAssigned;
        this.whoWasAssignee = whoWasAssignee;
        this.dateOfAssign = dateOfAssign;
        isActive = true;
    }
}

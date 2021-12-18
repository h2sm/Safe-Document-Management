package com.h2sm.mainservice.assignmentService.dto;

import com.h2sm.mainservice.documentService.dto.Document;
import com.h2sm.mainservice.employeeService.employees.Employee;
import java.util.Date;
import java.util.List;

public class Assignment {
    private long assignmentID;
    private Employee whoAssigned;
    private Employee whoWorkedOnAssignment;
    private Date dateOfAssign;
    private boolean isDone;
    private List<Document> listOfDocuments;
}

package com.h2sm.mainservice.signService.dto;

import com.h2sm.mainservice.documentService.dto.Document;
import com.h2sm.mainservice.employeeService.employees.Employee;
import lombok.Data;

import java.io.Serializable;

@Data
public class Sign implements Serializable {
    private Employee director;
    private Document document;
    private boolean isSigned;
}

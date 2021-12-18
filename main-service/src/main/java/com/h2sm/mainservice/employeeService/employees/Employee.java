package com.h2sm.mainservice.employeeService.employees;

import com.h2sm.mainservice.employeeService.positions.Position;
import lombok.Data;

@Data
public abstract class Employee {
    private long employeeID;
    private Position position;
}

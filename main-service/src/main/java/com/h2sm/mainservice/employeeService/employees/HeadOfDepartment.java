package com.h2sm.mainservice.employeeService.employees;

import com.h2sm.mainservice.employeeService.positions.Position;

public class HeadOfDepartment extends Employee{
    private long id;
    private final Position position = Position.HeadOfDepartment;
}

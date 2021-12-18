package com.h2sm.mainservice.employeeService.employees;

import com.h2sm.mainservice.employeeService.positions.Position;

public class Director extends Employee{
    private final Position position = Position.Director;
    private long id;
}

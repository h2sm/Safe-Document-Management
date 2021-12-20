package com.h2sm.mainservice.employeeService.contollers;

import com.h2sm.mainservice.employeeService.employees.Employee;
import com.h2sm.mainservice.employeeService.positions.Position;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @GetMapping("/getEmployees")
    public List<Employee> getListOfEmployees(){
        return null;
    }

    @GetMapping("/getEmplByPosition")
    public List<Employee> getEmployeesOfThisPosition(@RequestParam("pos") Optional<Position> position){
        return null;
    }
    @PostMapping("/add")
    public ResponseEntity.BodyBuilder addEmployee(Employee e){
        return ResponseEntity.accepted();
    }
}

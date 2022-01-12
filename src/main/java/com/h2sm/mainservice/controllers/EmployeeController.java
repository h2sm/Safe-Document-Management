package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.dtos.Position;
import com.h2sm.mainservice.utils.ContextUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @GetMapping("/getEmployees")
    public List<Worker> getListOfEmployees(){
        return null;
    }

    @GetMapping("/getEmplByPosition")
    public List<Worker> getEmployeesOfThisPosition(@RequestParam("pos") Optional<Position> position){
        return null;
    }
    @PostMapping("/addEmployee")
    public ResponseEntity.BodyBuilder addEmployee(Worker e){
        return ResponseEntity.accepted();
    }
    @GetMapping("/getMyName")
    public String returnMyName(){
        return ContextUtil.getAuthorizedUserName();
    }
}

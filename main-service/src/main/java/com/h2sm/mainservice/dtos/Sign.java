package com.h2sm.mainservice.dtos;

import com.h2sm.mainservice.dtos.Document;
import com.h2sm.mainservice.dtos.Employee;
import lombok.Data;

import java.io.Serializable;

@Data
public class Sign implements Serializable {
    private Employee director;
    private Document document;
    private boolean isSigned;
}

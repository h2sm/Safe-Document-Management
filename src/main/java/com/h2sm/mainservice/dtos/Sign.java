package com.h2sm.mainservice.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sign implements Serializable {
    private Worker director;
    private Document document;
    private boolean isSigned;
}

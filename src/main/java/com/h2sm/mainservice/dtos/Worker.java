package com.h2sm.mainservice.dtos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Worker implements Serializable {
    @Id
    private long id;
    @
    private String name;
    private String surname;
    private String email;
    private String password;
    private Position position;
}

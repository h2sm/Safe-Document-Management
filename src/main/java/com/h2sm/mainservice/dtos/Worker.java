package com.h2sm.mainservice.dtos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private long id;
    @Column(name = "uname")
    private String name;
    @Column(name = "usurname")
    private String surname;
    @Column(name = "uemail")
    private String email;
    @Column(name = "upasswd")
    private String password;
    @Enumerated(EnumType.STRING)
    private Position position;
}

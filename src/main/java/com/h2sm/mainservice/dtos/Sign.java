package com.h2sm.mainservice.dtos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sid")
    private long id;
    @Column(name = "workersids")
    private String workersIDs;
    @Column(name = "documentid")
    @OneToOne
    private Document document;
}

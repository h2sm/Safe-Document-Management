package com.h2sm.mainservice.dtos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "sign")
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "directorsigned")
    private boolean isDirectorSigned;
    @Column(name = "headSigned")
    private boolean isHeadSigned;
    @Column(name = "workerSigned")
    private boolean isWorkerSigned;
    @JoinColumn(name = "documentid")
    @OneToOne
    private Document document;
    @JoinColumn(name = "assignentid")
    @OneToOne
    private Assignment assignment;
    public Sign(){}
}

package com.h2sm.mainservice.dtos;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "documents")
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "docid")
    private long id;
    @Column(name = "doc")
    private byte[] data;
    @Column(name = "whouploaded")
    @JoinColumn(name = "worker")
    @OneToOne
    private Worker whoUploaded;
}

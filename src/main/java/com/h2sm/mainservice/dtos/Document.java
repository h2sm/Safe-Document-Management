package com.h2sm.mainservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "document")
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "doc")
    private byte[] data;
    public Document(byte[] data){
        this.data = data;
    }
}

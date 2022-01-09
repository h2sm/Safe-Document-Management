package com.h2sm.mainservice.dtos;

import com.h2sm.mainservice.configs.PositionConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "worker")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
//    @Enumerated(EnumType.STRING)
    @Column(name = "uposition")
    @Convert(converter = PositionConverter.class)
    private Position position;
}

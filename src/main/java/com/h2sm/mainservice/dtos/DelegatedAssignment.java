package com.h2sm.mainservice.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "delegateassignment")
@NoArgsConstructor
public class DelegatedAssignment {
    @Id
    @Column(name = "daid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "assignmentid")
    @OneToOne(fetch = FetchType.LAZY)
    private Assignment assignment;
    @JoinColumn(name = "changedassignee")
    @OneToOne(fetch = FetchType.LAZY)
    private Worker newAssignee;

    public DelegatedAssignment(Assignment a, Worker w){
        this.assignment = a;
        this.newAssignee = w;
    }
}

package com.h2sm.mainservice.dtos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "delegateassignment")
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
}

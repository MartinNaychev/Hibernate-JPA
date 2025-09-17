package org.example.entities.Hospital;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comments;

    public Diagnosis() {}
}

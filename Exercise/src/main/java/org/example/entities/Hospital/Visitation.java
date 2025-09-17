package org.example.entities.Hospital;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "visitation")
public class Visitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private Instant date;

    @Basic
    private String comments;

    @ManyToOne
    private Patient patient;

    public Visitation() {}
}

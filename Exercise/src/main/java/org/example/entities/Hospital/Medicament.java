package org.example.entities.Hospital;

import jakarta.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    public Medicament() {}

}

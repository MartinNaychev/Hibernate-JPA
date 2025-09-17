package org.example.entities.Hospital;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fist_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Basic
    private String address;

    @Basic
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "has_insurance")
    private boolean hasInsurance;

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class)
    private List<Visitation> visitations;

    @OneToMany
    private List<Diagnosis> diagnoses;

    @ManyToMany
    private Set<Medicament> medicaments;


    public Patient() {
        this.visitations = new ArrayList<>();
        this.diagnoses = new ArrayList<>();
        this.medicaments = new HashSet<>();
    }
}

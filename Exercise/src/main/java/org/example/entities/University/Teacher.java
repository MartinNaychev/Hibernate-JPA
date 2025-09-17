package org.example.entities.University;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {


    @Basic
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    public Teacher() {
        super();
    }


}

package org.example.entities.SalesDatabase;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @Basic
    private String email;

    @Basic
    private String credit_card_number;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class)
    private Set<Sale> orders;

    public Customer() {
        this.orders = new HashSet<>();
    }

    public Set<Sale> getOrders() {
        return orders;
    }

    public void setOrders(Set<Sale> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }
}

package org.example.entities.Betting;

import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @Enumerated(EnumType.STRING)
    private PositionEnum id;

    @Basic
    private String description;

    public Position() {
    }

    public PositionEnum getId() {
        return id;
    }

    public void setId(PositionEnum id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

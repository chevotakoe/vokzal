package com.example.vokzalproj.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "role")
    private String role;
    @Column(name = "train_id")
    private int trainId;
    @Column(name = "name")
    private String name;
}

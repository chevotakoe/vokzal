package com.example.vokzalproj.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "routs")
public class Rout {
    @Id
    @Column(name = "id")
    @Setter
    @Getter
    private int id;

    @Column(name = "departure")
    @Getter
    private String departure;

    @Column(name = "destination")
    @Getter
    private String destination;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "train_routs",
            joinColumns = @JoinColumn(name = "rout_id"),
            inverseJoinColumns = @JoinColumn(name = "train_id")
    )
    @Getter
    Set<Train> trains = new HashSet<>();


}

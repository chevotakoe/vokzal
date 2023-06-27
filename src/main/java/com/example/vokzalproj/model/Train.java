package com.example.vokzalproj.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "trains")
public class Train {
    @Id
    @Column(name = "id")
    @Setter
    @Getter
    private int id;

    @Column(name = "renovation_year")
    @Getter
    private int renovationYear;

    @Column(name = "manufacture_year")
    @Getter
    private int manufactureYear;

    @Column(name = "seats")
    @Getter
    private int seats;

    @ManyToMany(mappedBy = "trains")
    @Getter
    Set<Rout> routs = new HashSet<>();


}

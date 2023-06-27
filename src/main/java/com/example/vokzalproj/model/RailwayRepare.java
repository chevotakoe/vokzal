package com.example.vokzalproj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
@Entity
@Table(name = "railway_repare")
public class RailwayRepare {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "rout_id")
    private int routId;

    @Column(name = "place")
    private String place;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "is_done")
    private boolean isDone;
}

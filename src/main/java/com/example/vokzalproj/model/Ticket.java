package com.example.vokzalproj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "rout_id")
    private int routId;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    private Timestamp timestamp;
    @Column(name = "dest_time")
    private int destTime;
}

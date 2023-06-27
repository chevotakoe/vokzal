package com.example.vokzalproj.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "staff_fines")
public class StaffFine {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "fine")
    private double fine;

    @Column(name = "is_payed")
    private boolean isPayed;
}

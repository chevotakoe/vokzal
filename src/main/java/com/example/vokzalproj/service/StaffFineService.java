package com.example.vokzalproj.service;

import com.example.vokzalproj.model.StaffFine;

import java.util.ArrayList;

public interface StaffFineService {
    StaffFine getStaffFineById(int id);
    ArrayList<StaffFine> getAllStaffFines();
    void addStaffFine(StaffFine staffFine);
    void updateStaffFineById(StaffFine staffFine, int id);
    boolean removeStaffFineById(int id);
}

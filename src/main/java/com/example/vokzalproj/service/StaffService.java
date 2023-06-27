package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Staff;

import java.util.ArrayList;

public interface StaffService {
    Staff getStaffById(int id);
    ArrayList<Staff> getAllStaff();
    void addStaff(Staff staff);
    void updateStaffById(Staff staff, int id);
    boolean removeStaffById(int id);
}

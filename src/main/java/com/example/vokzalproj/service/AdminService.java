package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Admin;

import java.util.ArrayList;

public interface AdminService {
    Admin getAdminById(int id);
    ArrayList<Admin> getAllAdmins();
    void addAdmin(Admin admin);
    void updateAdminById(Admin admin, int id);
    boolean removeAdminById(int id);
}

package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Admin;
import com.example.vokzalproj.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public Admin getAdminById(int id) {
        Admin admin = new Admin();
        if(adminRepository.existsById(id)){
            admin = adminRepository.findById(id).orElse(null);
        }
        return admin;
    }

    @Override
    public ArrayList<Admin> getAllAdmins() {
        ArrayList<Admin> admins = (ArrayList<Admin>) adminRepository.findAll();
        return admins;
    }

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void updateAdminById(Admin admin, int id) {
        admin.setId(id);
        adminRepository.save(admin);
    }

    @Override
    public boolean removeAdminById(int id) {
        if(adminRepository.existsById(id)){
              adminRepository.deleteById(id);
              return true;
        }
        return false;


    }
}

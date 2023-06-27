package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Admin;
import com.example.vokzalproj.model.StaffFine;
import com.example.vokzalproj.repository.AdminRepository;
import com.example.vokzalproj.repository.StaffFineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StaffFineServiceImpl implements StaffFineService{
    @Autowired
    private StaffFineRepository staffFineRepository;

    @Override
    public StaffFine getStaffFineById(int id) {
        StaffFine fine = new StaffFine();
        if(staffFineRepository.existsById(id)){
            fine = staffFineRepository.findById(id).orElse(null);
        }
        return fine;
    }

    @Override
    public ArrayList<StaffFine> getAllStaffFines() {
        ArrayList<StaffFine> fines = (ArrayList<StaffFine>) staffFineRepository.findAll();
        return fines;
    }

    @Override
    public void addStaffFine(StaffFine staffFine) {
        staffFineRepository.save(staffFine);
    }

    @Override
    public void updateStaffFineById(StaffFine staffFine, int id) {
        staffFine.setId(id);
        staffFineRepository.save(staffFine);
    }

    @Override
    public boolean removeStaffFineById(int id) {
        if(staffFineRepository.existsById(id)){
            staffFineRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Admin;
import com.example.vokzalproj.model.Staff;
import com.example.vokzalproj.model.StaffFine;
import com.example.vokzalproj.repository.StaffFineRepository;
import com.example.vokzalproj.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff getStaffById(int id) {
        Staff staff = new Staff();
        if(staffRepository.existsById(id)){
            staff = staffRepository.findById(id).orElse(null);
        }
        return staff;
    }

    @Override
    public ArrayList<Staff> getAllStaff() {
        ArrayList<Staff> staff = (ArrayList<Staff>) staffRepository.findAll();
        return staff;
    }

    @Override
    public void addStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void updateStaffById(Staff staff, int id) {
        staff.setId(id);
        staffRepository.save(staff);
    }

    @Override
    public boolean removeStaffById(int id) {
        if(staffRepository.existsById(id)){
            staffRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Admin;
import com.example.vokzalproj.model.RailwayRepare;
import com.example.vokzalproj.repository.AdminRepository;
import com.example.vokzalproj.repository.RailwayRepareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RailwayRepareServiceImpl implements RailwayRepareService{
    @Autowired
    private RailwayRepareRepository repareRepository;

    @Override
    public RailwayRepare getRepareById(int id) {
        RailwayRepare repare = new RailwayRepare();
        if(repareRepository.existsById(id)){
            repare = repareRepository.findById(id).orElse(null);
        }
        return repare;
    }

    @Override
    public ArrayList<RailwayRepare> getAllRepares() {
        ArrayList<RailwayRepare> repares = (ArrayList<RailwayRepare>) repareRepository.findAll();
        return repares;
    }

    @Override
    public void addRepare(RailwayRepare repare) {
        repareRepository.save(repare);
    }

    @Override
    public void updateRepareById(RailwayRepare repare, int id) {
        repare.setId(id);
        repareRepository.save(repare);
    }
}

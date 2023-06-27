package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Rout;
import com.example.vokzalproj.repository.RoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoutServiceImpl implements RoutService{

    @Autowired
    private RoutRepository routRepository;

    @Override
    public Rout getRoutById(int id) {
        Rout rout = new Rout();
        if(routRepository.existsById(id)){
            rout = routRepository.findById(id).orElse(null);
        }
        return rout;
    }

    @Override
    public ArrayList<Rout> getAllRouts() {
        ArrayList<Rout> rout = (ArrayList<Rout>) routRepository.findAll();
        return rout;
    }

    @Override
    public void addRout(Rout rout) {
        routRepository.save(rout);
    }

    @Override
    public void updateRoutById(Rout rout, int id) {
        rout.setId(id);
        routRepository.save(rout);
    }

    @Override
    public boolean removeRoutById(int id) {
        if(routRepository.existsById(id)){
            routRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

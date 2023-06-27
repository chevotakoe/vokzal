package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Rout;

import java.util.ArrayList;

public interface RoutService {
    Rout getRoutById(int id);
    ArrayList<Rout> getAllRouts();
    void addRout(Rout rout);
    void updateRoutById(Rout rout, int id);
    boolean removeRoutById(int id);
}

package com.example.vokzalproj.service;

import com.example.vokzalproj.model.RailwayRepare;

import java.util.ArrayList;

public interface RailwayRepareService {
    RailwayRepare getRepareById(int id);
    ArrayList<RailwayRepare> getAllRepares();
    void addRepare(RailwayRepare repare);
    void updateRepareById(RailwayRepare repare, int id);
}

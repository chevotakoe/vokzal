package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Train;

import java.util.ArrayList;

public interface TrainService {
    Train getTrainById(int id);
    ArrayList<Train> getAllTrains();
    void addTrain(Train train);
    void updateTrainById(Train train, int id);
    boolean removeTrainById(int id);
}

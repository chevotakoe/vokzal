package com.example.vokzalproj.service;

import com.example.vokzalproj.model.Admin;
import com.example.vokzalproj.model.Train;
import com.example.vokzalproj.repository.TicketRepository;
import com.example.vokzalproj.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TrainServiceImpl implements TrainService{
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public Train getTrainById(int id) {
        Train train = new Train();
        if(trainRepository.existsById(id)){
            train = trainRepository.findById(id).orElse(null);
        }
        return train;
    }

    @Override
    public ArrayList<Train> getAllTrains() {
        ArrayList<Train> trains = (ArrayList<Train>) trainRepository.findAll();
        return trains;
    }

    @Override
    public void addTrain(Train train) {
        trainRepository.save(train);
    }

    @Override
    public void updateTrainById(Train train, int id) {
        train.setId(id);
        trainRepository.save(train);
    }

    @Override
    public boolean removeTrainById(int id) {
        if(trainRepository.existsById(id)){
            trainRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
//Доделать создание мени ту мени в спринге
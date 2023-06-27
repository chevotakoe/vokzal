package com.example.vokzalproj.repository;

import com.example.vokzalproj.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {
}

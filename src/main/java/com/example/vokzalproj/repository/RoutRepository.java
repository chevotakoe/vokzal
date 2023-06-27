package com.example.vokzalproj.repository;

import com.example.vokzalproj.model.Rout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoutRepository extends JpaRepository<Rout, Integer> {

}

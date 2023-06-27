package com.example.vokzalproj.repository;

import com.example.vokzalproj.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}

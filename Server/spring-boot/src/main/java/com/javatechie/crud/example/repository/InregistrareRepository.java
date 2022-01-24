package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Inregistrare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InregistrareRepository extends JpaRepository<Inregistrare,Integer> {
   // Inregistrare findByName(String name);
}

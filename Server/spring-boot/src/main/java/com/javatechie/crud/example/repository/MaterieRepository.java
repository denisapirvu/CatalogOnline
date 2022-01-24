package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Materie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterieRepository extends JpaRepository<Materie,Integer> {
   // Materie findByName(String name);
}
package com.javatechie.crud.example.repository;


import com.javatechie.crud.example.entity.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupaRepository extends JpaRepository<Grupa,Integer> {
    //Grupa findByNume_grupa(String nume_grupa);
}

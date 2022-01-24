package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Grupa;
import com.javatechie.crud.example.entity.Materie;
import com.javatechie.crud.example.repository.GrupaRepository;
import com.javatechie.crud.example.repository.MaterieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterieService {
    @Autowired
    private MaterieRepository repository;

    public Materie saveMaterie(Materie materie) {
        return repository.save(materie);
    }

    public List<Materie> saveMaterii(List<Materie> materii) {
        return repository.saveAll(materii);
    }

    public List<Materie> getMaterii() {
        return repository.findAll();
    }

    public Materie getMaterieById(int id) {
        return repository.findById(id).orElse(null);
    }

   // public Materie getMaterieByName(String name) {
 //       return repository.findByName(name);
  //  }

    public String deleteMaterie(int id) {
        repository.deleteById(id);
        return "Materie removed !! " + id;
    }

    public Materie updateMaterie(Materie materie) {
        Materie existingMaterie = repository.findById(materie.getId_materie()).orElse(null);
        existingMaterie.setNume_materie(materie.getNume_materie());
        existingMaterie.setId_profesor(materie.getId_profesor());

        return repository.save(existingMaterie);
    }


}

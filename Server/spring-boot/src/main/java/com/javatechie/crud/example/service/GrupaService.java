package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Grupa;
import com.javatechie.crud.example.entity.Student;
import com.javatechie.crud.example.repository.GrupaRepository;
import com.javatechie.crud.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupaService {
    @Autowired
    private GrupaRepository repository;

    public Grupa saveGrupa(Grupa grupa) {
        return repository.save(grupa);
    }

    public List<Grupa> saveGrupe(List<Grupa> grupe) {
        return repository.saveAll(grupe);
    }

    public List<Grupa> getGrupe() {
        return repository.findAll();
    }

    public Grupa getGrupaById(int id) {
        return repository.findById(id).orElse(null);
    }

    //public Grupa getGrupaByNumeGrupa(String name) {
   //     return repository.findByNume_grupa(name);
  //  }

    public String deleteGrupa(int id) {
        repository.deleteById(id);
        return "Grupa removed !! " + id;
    }

    public Grupa updateGrupa(Grupa grupa) {
        Grupa existingGrupa = repository.findById(grupa.getId_grupa()).orElse(null);
        existingGrupa.setNume_grupa(grupa.getNume_grupa());
        existingGrupa.setMaterie1(grupa.getMaterie1());
        existingGrupa.setMaterie2(grupa.getMaterie2());
        existingGrupa.setMaterie3(grupa.getMaterie3());
        existingGrupa.setMaterie4(grupa.getMaterie4());
        existingGrupa.setMaterie5(grupa.getMaterie5());
        existingGrupa.setMaterie6(grupa.getMaterie6());
        existingGrupa.setMaterie7(grupa.getMaterie7());
        existingGrupa.setMaterie8(grupa.getMaterie8());
        existingGrupa.setMaterie9(grupa.getMaterie9());
        existingGrupa.setMaterie10(grupa.getMaterie10());


        return repository.save(existingGrupa);
    }


}

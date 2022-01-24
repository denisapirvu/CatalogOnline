package com.javatechie.crud.example.service;


import com.javatechie.crud.example.entity.Inregistrare;
import com.javatechie.crud.example.entity.Student;
import com.javatechie.crud.example.repository.InregistrareRepository;
import com.javatechie.crud.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InregistrareService {
    @Autowired
    private InregistrareRepository repository;

    public Inregistrare saveInregistrare(Inregistrare inregistrare) {
        return repository.save(inregistrare);
    }

    public List<Inregistrare> saveInregistrari(List<Inregistrare> inregistrari) {
        return repository.saveAll(inregistrari);
    }

    public List<Inregistrare> getInregistrari() {
        return repository.findAll();
    }

    public Inregistrare getInregistrareById(int id) {
        return repository.findById(id).orElse(null);
    }

   // public Inregistrare getInregistrareByName(String name) {
  //      return repository.findByName(name);
  //  }

    public String deleteInregistrare(int id) {
        repository.deleteById(id);
        return "Inregistrare removed !! " + id;
    }

    public Inregistrare updateInregistrare(Inregistrare inregistrare) {
        Inregistrare existingInregistrare = repository.findById(inregistrare.getId_inregistrare()).orElse(null);
        existingInregistrare.setId_materie(inregistrare.getId_materie());
        existingInregistrare.setId_profesor(inregistrare.getId_profesor());
        existingInregistrare.setId_student(inregistrare.getId_student());

        existingInregistrare.setLaborator1(inregistrare.getLaborator1());
        existingInregistrare.setPrezenta1(inregistrare.getPrezenta1());

        existingInregistrare.setLaborator2(inregistrare.getLaborator2());
        existingInregistrare.setPrezenta2(inregistrare.getPrezenta2());

        existingInregistrare.setLaborator3(inregistrare.getLaborator3());
        existingInregistrare.setPrezenta3(inregistrare.getPrezenta3());

        existingInregistrare.setLaborator4(inregistrare.getLaborator4());
        existingInregistrare.setPrezenta4(inregistrare.getPrezenta4());

        existingInregistrare.setLaborator5(inregistrare.getLaborator5());
        existingInregistrare.setPrezenta5(inregistrare.getPrezenta5());

        existingInregistrare.setLaborator6(inregistrare.getLaborator6());
        existingInregistrare.setPrezenta6(inregistrare.getPrezenta6());

        return repository.save(existingInregistrare);
    }


}

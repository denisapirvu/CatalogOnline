package com.javatechie.crud.example.controller;


import com.javatechie.crud.example.entity.Inregistrare;
import com.javatechie.crud.example.service.InregistrareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InregistrareController {

    @Autowired
    private InregistrareService service;

    @PostMapping("/addInregistrare")
    public Inregistrare addInregistrare(@RequestBody Inregistrare inregistrare){
        return service.saveInregistrare(inregistrare);
    }
    @PostMapping("/addInregistrari")
    public List<Inregistrare> addInregistrares(@RequestBody List<Inregistrare> inregistrari){
        return service.saveInregistrari(inregistrari);
    }
    @GetMapping("/Inregistrari")
    public List<Inregistrare> findAllInregistrari(){
        return service.getInregistrari();
    }
    @GetMapping("/Inregistrare/{id_Inregistrare}")
    public Inregistrare findInregistrareById(@PathVariable int id_inregistrare){
        return service.getInregistrareById(id_inregistrare);
    }
  //  @GetMapping("/Inregistrare/{name}")
    //public Inregistrare findInregistrareByName(@PathVariable String name){
    //    return service.getInregistrareByName(name);
  //  }
    @PutMapping("/updateInregistrare")
    public Inregistrare updateInregistrare(@RequestBody Inregistrare inregistrare){
        return service.updateInregistrare(inregistrare);
    }
    @DeleteMapping("/deleteInregistrare/{id_inregistrare}")
    public String deleteInregistrare(@PathVariable int id_inregistrare){
        return service.deleteInregistrare(id_inregistrare);
    }

}

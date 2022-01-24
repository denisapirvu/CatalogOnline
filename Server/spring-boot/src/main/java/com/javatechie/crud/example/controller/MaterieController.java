package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Materie;
import com.javatechie.crud.example.service.MaterieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterieController {
    @Autowired
    private MaterieService service;

    @PostMapping("/addMaterie")
    public Materie addMaterie(@RequestBody Materie materie){
        return service.saveMaterie(materie);
    }
    @PostMapping("/addMaterii")
    public List<Materie> addMateries(@RequestBody List<Materie> materii){
        return service.saveMaterii(materii);
    }
    @GetMapping("/Materii")
    public List<Materie> findAllMaterii(){
        return service.getMaterii();
    }
    @GetMapping("/Materie/{id_Materie}")
    public Materie findMaterieById(@PathVariable int id_Materie){
        return service.getMaterieById(id_Materie);
    }
  //  @GetMapping("/Materie/{name}")
  //  public Materie findMaterieByName(@PathVariable String name){
  //      return service.getMaterieByName(name);
   // }
    @PutMapping("/updateMaterie")
    public Materie updateMaterie(@RequestBody Materie Materie){
        return service.updateMaterie(Materie);
    }
    @DeleteMapping("/deleteMaterie/{id_Materie}")
    public String deleteMaterie(@PathVariable int id_Materie){
        return service.deleteMaterie(id_Materie);
    }

}

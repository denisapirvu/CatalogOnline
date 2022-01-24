package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Grupa;
import com.javatechie.crud.example.service.GrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrupaController {
    @Autowired
    private GrupaService service;

    @PostMapping("/addGrupa")
    public Grupa addGrupa(@RequestBody Grupa grupa){
        return service.saveGrupa(grupa);
    }
    @PostMapping("/addGrupas")
    public List<Grupa> addGrupe(@RequestBody List<Grupa> grupe){
        return service.saveGrupe(grupe);
    }
    @GetMapping("/Grupe")
    public List<Grupa> findAllGrupe(){
        return service.getGrupe();
    }
    @GetMapping("/Grupa/{id_Grupa}")
    public Grupa findGrupaById(@PathVariable int id_Grupa){
        return service.getGrupaById(id_Grupa);
    }
   // @GetMapping("/Grupa/{name}")
  //  public Grupa findGrupaByName(@PathVariable String name){
  //      return service.getGrupaByNumeGrupa(name);
  //  }
    @PutMapping("/updateGrupa")
    public Grupa updateGrupa(@RequestBody Grupa grupa){
        return service.updateGrupa(grupa);
    }
    @DeleteMapping("/deleteGrupa/{id_grupa}")
    public String deleteGrupa(@PathVariable int id_grupa){
        return service.deleteGrupa(id_grupa);
    }

}

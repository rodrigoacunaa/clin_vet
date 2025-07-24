/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.model.Mascota;
import com.veterinaria.veterinaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    @Autowired private IMascotaService mascotaServ;
    
    @PostMapping("/mascotas/crear")
    public String crearMascota(@RequestBody Mascota m){
        mascotaServ.guardarMascota(m);
        return "Mascota registrada correctamente";
    }
    
    @GetMapping("/mascotas/buscar")
    public Mascota findMascotaById(@RequestParam Long id){
        return mascotaServ.findMascotaById(id);
    }
    
    @GetMapping("/mascotas/listar")
    public List<Mascota> listarMascotas(){
        return mascotaServ.findAllMascotas();
    }
    
    @PutMapping("/mascotas/editar")
    public Mascota editMascota(@RequestBody Mascota m){
        mascotaServ.editMascota(m);
        return mascotaServ.findMascotaById(m.getIdMascota());
    }
    
    @DeleteMapping("/mascotas/eliminar")
    public String deleteMascotaById(@RequestParam Long id){
        mascotaServ.deleteMascotaById(id);
        return "Mascota eliminada correctamente";
    }
    
    @GetMapping("/mascotas/listar/{especie}/{raza}")
    public List<Mascota> listarMascotasByEspecieAndRaza(@PathVariable String especie, @PathVariable String raza){
        return mascotaServ.findByEspecieAndRaza(especie, raza);
    }
}

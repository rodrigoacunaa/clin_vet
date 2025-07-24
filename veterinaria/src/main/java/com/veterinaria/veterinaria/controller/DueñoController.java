/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.dto.MascotaDueñoDTO;
import com.veterinaria.veterinaria.model.Dueño;
import com.veterinaria.veterinaria.model.Mascota;
import com.veterinaria.veterinaria.service.IDueñoService;
import com.veterinaria.veterinaria.service.IMascotaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DueñoController {

    @Autowired private IDueñoService dueñoServ;
    
    @Autowired private IMascotaService mascotaServ;
    
    @PostMapping("/dueños/crear")
    public String saveDueño(@RequestBody Dueño d){
        dueñoServ.guardarDueño(d);
        return "Dueño registrado correctamente";
    }
    
    @GetMapping("/dueños/buscar")
    public Dueño findDueñoById(@RequestParam Long id){
        return dueñoServ.findDueñoById(id);
    }
    
    @GetMapping("dueños/mascotas")
    public List<MascotaDueñoDTO> getDTO(){
        List<Mascota> mascotas = mascotaServ.findAllMascotas();
        List<MascotaDueñoDTO> mascoDueño = new ArrayList<MascotaDueñoDTO>();
        for(Mascota m:mascotas){
                MascotaDueñoDTO mascoD = new MascotaDueñoDTO();
                mascoD.setNombre_mascota(m.getNombre());
                mascoD.setEspecie(m.getEspecie());
                mascoD.setRaza(m.getRaza());
                mascoD.setNombre_dueño(m.getD().getNombre());
                mascoD.setApellido_dueño(m.getD().getApellido());
                mascoDueño.add(mascoD);
        }
        return mascoDueño;
        
    }
    
    @GetMapping("/dueños/listar")
    public List<Dueño> listDueños(){
        return dueñoServ.findAllDueños();
    }
    
    @PutMapping("/dueños/editar")
    public Dueño editDueño(@RequestBody Dueño d){
        dueñoServ.editDueño(d);
        return dueñoServ.findDueñoById(d.getId());
    }
    
    @DeleteMapping("/dueños/eliminar")
    public String deleteDueñoById(@RequestParam Long id){
        dueñoServ.deleteDueñoById(id);
        return "Dueño eliminado";
    }
    
}

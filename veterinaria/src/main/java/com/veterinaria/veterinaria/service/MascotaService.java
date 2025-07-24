/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.service;

import com.veterinaria.veterinaria.model.Mascota;
import com.veterinaria.veterinaria.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {
    @Autowired private IMascotaRepository mascotaRep;

    @Override
    public void guardarMascota(Mascota m) {
        mascotaRep.save(m);
    }

    @Override
    public Mascota findMascotaById(Long id) {
        return mascotaRep.findById(id).orElse(null);
    }

    @Override
    public List<Mascota> findAllMascotas() {
        return mascotaRep.findAll();
    }

    @Override
    public void editMascota(Mascota m) {
        this.guardarMascota(m);
    }

    @Override
    public void deleteMascotaById(Long id) {
        mascotaRep.deleteById(id);
    }

    @Override
    public List<Mascota> findByEspecieAndRaza(String especie, String raza) {
        return mascotaRep.findByEspecieContainingAndRazaContaining(especie, raza);
    }
    
    
}

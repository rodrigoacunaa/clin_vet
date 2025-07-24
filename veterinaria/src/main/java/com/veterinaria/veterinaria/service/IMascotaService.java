/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.veterinaria.veterinaria.service;

import com.veterinaria.veterinaria.model.Mascota;
import java.util.List;


public interface IMascotaService {
    public void guardarMascota(Mascota m);
    
    public Mascota findMascotaById(Long id);
    
    public List<Mascota> findAllMascotas();
    
    public void editMascota(Mascota m);
    
    public void deleteMascotaById(Long id);
    
    public List<Mascota> findByEspecieAndRaza(String especie, String raza);
}

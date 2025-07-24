/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.veterinaria.veterinaria.service;

import com.veterinaria.veterinaria.model.Dueño;
import java.util.List;


public interface IDueñoService {
    public void guardarDueño(Dueño d);
    
    public Dueño findDueñoById(Long id);
    
    public List<Dueño> findAllDueños();
    
    public void editDueño(Dueño d);
    
    public void deleteDueñoById(Long id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.service;

import com.veterinaria.veterinaria.model.Dueño;
import com.veterinaria.veterinaria.repository.IDueñoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DueñoService implements IDueñoService {
    
    @Autowired private IDueñoRepository dueñoRep;

    @Override
    public void guardarDueño(Dueño d) {
        dueñoRep.save(d);
    }

    @Override
    public Dueño findDueñoById(Long id) {
        return dueñoRep.findById(id).orElse(null);
    }

    @Override
    public List<Dueño> findAllDueños() {
        return dueñoRep.findAll();
    }

    @Override
    public void editDueño(Dueño d) {
        this.guardarDueño(d);
    }

    @Override
    public void deleteDueñoById(Long id) {
        dueñoRep.deleteById(id);
    }

}

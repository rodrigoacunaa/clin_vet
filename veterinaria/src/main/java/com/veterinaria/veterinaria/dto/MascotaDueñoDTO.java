/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.veterinaria.veterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaDueñoDTO implements Serializable {
    private String nombre_mascota;
    private String especie;
    private String raza;
    private String nombre_dueño;
    private String apellido_dueño;

    public MascotaDueñoDTO() {
    }

    public MascotaDueñoDTO(String nombre_mascota, String especie, String raza, String nombre_dueño, String apellido_dueño) {
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.nombre_dueño = nombre_dueño;
        this.apellido_dueño = apellido_dueño;
    }
    
}

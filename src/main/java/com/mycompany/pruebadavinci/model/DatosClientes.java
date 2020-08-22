/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.model;

import java.io.Serializable;

/**
 *
 * @author Miguel Rojas
 */
public class DatosClientes implements Serializable{
    
    private String Nombres;
    private String Apellidos;
    private String Telefonos;
    private String Direccion1;
    private String Direccion2;
    private String Direccion3;

    public DatosClientes() {
        super();
    }

    public DatosClientes(String Nombres, String Apellidos, String Telefonos, String Direccion1, String Direccion2, String Direccion3) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefonos = Telefonos;
        this.Direccion1 = Direccion1;
        this.Direccion2 = Direccion2;
        this.Direccion3 = Direccion3;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(String Telefonos) {
        this.Telefonos = Telefonos;
    }

    public String getDireccion1() {
        return Direccion1;
    }

    public void setDireccion1(String Direccion1) {
        this.Direccion1 = Direccion1;
    }

    public String getDireccion2() {
        return Direccion2;
    }

    public void setDireccion2(String Direccion2) {
        this.Direccion2 = Direccion2;
    }

    public String getDireccion3() {
        return Direccion3;
    }

    public void setDireccion3(String Direccion3) {
        this.Direccion3 = Direccion3;
    }

    @Override
    public String toString() {
        return "DatosDocumento{" + "Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Telefonos=" + Telefonos + ", Direccion1=" + Direccion1 + ", Direccion2=" + Direccion2 + ", Direccion3=" + Direccion3 + '}';
    }
    
    
    
}

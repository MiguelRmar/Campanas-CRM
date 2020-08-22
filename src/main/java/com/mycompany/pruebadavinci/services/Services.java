/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.services;

import java.util.List;

/**
 *
 * @author Miguel Rojas
 */
public interface Services {

    //CRUD
    //CREATE
    public boolean createElement(Object elemento);
    //READ
    public Object Read(int id);
    //UPDATE
    public Object Update(Object elemento);
    //DELETE
    public boolean Delete(int id);    
}

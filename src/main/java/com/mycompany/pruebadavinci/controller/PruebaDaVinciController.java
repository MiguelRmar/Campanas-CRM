/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.controller;

import com.mycompany.pruebadavinci.Persistence.PruebaDaVinciDB;
import com.mycompany.pruebadavinci.model.DatosClientes;
import com.mycompany.pruebadavinci.services.Services;
import com.mycompany.pruebadavinci.services.impl.DatosClienteService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Rojas
 */

@RequestMapping("/session")
@RestController
public class PruebaDaVinciController {


    DatosClienteService dcs = new DatosClienteService();

    @RequestMapping(method = RequestMethod.GET, path = "/Clients/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") int id){
        try{
            DatosClientes dado = (DatosClientes) dcs.Read(id);
            return new ResponseEntity<>(dado, HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PruebaDaVinciController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/Clients")
    public ResponseEntity<?> getAll(){
        try{
            List<Object> dados = dcs.ReadAll();
            return new ResponseEntity<>(dados, HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(PruebaDaVinciController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 404", HttpStatus.NOT_FOUND);
        }
    }
    
    
    @RequestMapping(method = RequestMethod.POST , path = "/createEmployee")
    public ResponseEntity<?> setCliente(@RequestBody DatosClientes emp){
        try {
            Boolean b = dcs.createElement(emp);
            return new ResponseEntity<>(b, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(PruebaDaVinciController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR 406", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}


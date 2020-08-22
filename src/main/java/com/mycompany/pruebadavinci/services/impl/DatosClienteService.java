/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.services.impl;

import com.mycompany.pruebadavinci.DAO.impl.DatosClientesDAO;
import com.mycompany.pruebadavinci.model.DatosClientes;
import com.mycompany.pruebadavinci.services.Services;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Rojas
 */
@Service
public class DatosClienteService implements Services{
    
    DatosClientesDAO pdd = new DatosClientesDAO();

    @Override
    public boolean createElement(Object elemento) {
        boolean b = pdd.insert(elemento);
        return b;
    }

    @Override
    public Object Read(int id) {
        DatosClientes dc = (DatosClientes) pdd.consultById(id);
        return dc;
    }

    @Override
    public Object Update(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Object> ReadAll() {
        List<Object> ldc = pdd.consultAll();
        return ldc;
    }
    
}

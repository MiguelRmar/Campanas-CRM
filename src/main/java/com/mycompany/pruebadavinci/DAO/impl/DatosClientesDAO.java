/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.DAO.impl;

import com.mycompany.pruebadavinci.DAO.PruebaDavinciDAO;
import com.mycompany.pruebadavinci.Persistence.impl.DatosClienteDB;
import com.mycompany.pruebadavinci.model.DatosClientes;
import java.util.List;

/**
 *
 * @author Miguel Rojas
 */
public class DatosClientesDAO implements PruebaDavinciDAO{

    DatosClienteDB pddb = new DatosClienteDB();
    
    public List<Object> consultAll() {
        List<Object> ldc = pddb.getAll();
        return ldc;
    }

    @Override
    public Object consultById(int id) {
        DatosClientes dado = (DatosClientes) pddb.getById(id);
        return dado;
    }

    @Override
    public boolean insert(Object ob) {
        boolean b = pddb.insert(ob);
        return b;
    }

    @Override
    public boolean updateObject(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

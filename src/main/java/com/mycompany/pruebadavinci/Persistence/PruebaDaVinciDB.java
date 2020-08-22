/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.Persistence;

import com.mycompany.pruebadavinci.model.DatosClientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.ucp.jdbc.PoolDataSourceFactory;
import oracle.ucp.jdbc.PoolDataSource;

/**
 *
 * @author Miguel Rojas
 */
public interface PruebaDaVinciDB {
        
    public Object getById(int id);
    public List<Object> getAll();
    public boolean insert(Object obj);
   
}

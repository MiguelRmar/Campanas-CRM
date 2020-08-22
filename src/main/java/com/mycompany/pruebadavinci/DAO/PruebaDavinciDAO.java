/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.DAO;

import com.mycompany.pruebadavinci.model.DatosClientes;
import java.util.List;

/**
 *
 * @author Miguel Rojas
 */
public interface PruebaDavinciDAO {
    public Object consultById(int id) ;
    public boolean insert(Object ob);
    public boolean updateObject(Object ob);
    public boolean Delete(int id);
}

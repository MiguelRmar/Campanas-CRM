/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebadavinci.Persistence.impl;

import com.mycompany.pruebadavinci.Persistence.PruebaDaVinciDB;
import com.mycompany.pruebadavinci.model.DatosClientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Rojas
 */
public class DatosClienteDB implements PruebaDaVinciDB{
    
    String urlDatabase = "jdbc:oracle:thin:@database-1.cvxqxluy0dbq.us-east-2.rds.amazonaws.com:1521/ORCL";
    String usuarioDb = "admin";
    String passwordDb = "admin7994";
    Connection c = null;
    
    public void realizaConexion () throws SQLException{
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());          
            c =  DriverManager.getConnection(this.urlDatabase,this.usuarioDb,this.passwordDb);
        }catch(SQLException e){
            Logger.getLogger(PruebaDaVinciDB.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    
    @Override
    public Object getById(int id){
        String SQL ="SELECT * FROM informacionclientes WHERE id = "+id;   
        DatosClientes dd = null;
        
        try{
            if(c == null || c.isClosed()){
                realizaConexion();
            }
            PreparedStatement estatuto = c.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = estatuto.executeQuery();
            rs.next();
            if (rs.absolute(1)) {
                dd = new DatosClientes(rs.getString("NOMBRES"), rs.getString("APELLIDOS"), rs.getString("TELEFONO"), rs.getString("DIRECCION1"),rs.getString("DIRECCION2"),rs.getString("DIRECCION3"));
                estatuto.close();
                rs.close();
            }
            
        }catch(SQLException ex){
            ex.printStackTrace(); 
        }
        return dd;       
    }

    
    @Override
    public List<Object> getAll() {
        String SQL = "SELECT * FROM informacionclientes ";
        List<Object> LDC = new ArrayList<Object>();
        int idObjectCreate;
        try {
            if (c == null || c.isClosed()) {
                realizaConexion();
            }
            PreparedStatement pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = pstmt.executeQuery();
            int idObject;
            rs.next();
            if (rs.absolute(1)) {
                LDC = new ArrayList<Object>();
                idObject = rs.getInt("ID");
                LDC.add((DatosClientes) getById(idObject));
                idObjectCreate = idObject;
                while (rs.next()) {
                    idObject = rs.getInt("id");
                    if (idObject != idObjectCreate) {
                        LDC.add((DatosClientes) getById(idObject));
                        idObjectCreate = idObject;
                    }
                }
                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LDC;
    }

    @Override
    public boolean insert(Object obj) {
        DatosClientes dc = (DatosClientes) obj; 
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        String SQLcount = "SELECT count(distinct id) FROM informacionclientes";
        boolean res = false;
        try {
            if (c == null || c.isClosed()) {
                realizaConexion();
            }
            pstmt2 = c.prepareStatement(SQLcount, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = pstmt2.executeQuery();
            rs.next();
            int userid = rs.getInt("COUNT(DISTINCTID)") + 1;
            String SQL = "INSERT INTO informacionclientes (ID, NOMBRES, APELLIDOS, TELEFONO,DIRECCION1,DIRECCION2,DIRECCION3)"+
                    "VALUES (" + userid + ",'" + dc.getNombres()+"','"+dc.getApellidos()+"','"+dc.getTelefonos()+"','"+dc.getDireccion1()+"','"+dc.getDireccion2()+"','"+dc.getDireccion3()+"')";
            pstmt = c.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.execute();
            pstmt.close(); 
            res = true;
        }catch (SQLException ex) {
            Logger.getLogger(DatosClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
        
        
}

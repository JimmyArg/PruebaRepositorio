/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testWebb.dao;


import com.testWebb.bean.BeanUsuario;
import com.testWebb.interfacee.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.testWebb.util.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author SQA
 */
public class DaoUsuario implements CRUD{
    
    private String consulta;
    private ResultSet rs;
    public DaoUsuario(){
        consulta ="";
    }
    
    public DaoUsuario(String consulta) {
        this.consulta = consulta;
    }
    /**
     * Metodo que retorna un objeto de tipo ususario segun la consulta
     *
     * @param beanUsu
     * @return
     */
    public boolean crear(int idUsuario, String nombre, String apellido, String documento, String celular){
        consulta="Insert into usuario values(00,?,?,?,?)";
        Conexion conexion = new Conexion();
    
        try(Connection connection = conexion.obtenerConexion();
                PreparedStatement ps = connection.prepareCall(consulta);){
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, documento);
            ps.setString(4, celular);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    } 

    @Override
    public List listar() {
        ArrayList<BeanUsuario> listaUsu = new ArrayList<>();
        consulta="Select * from Usuario";
            rs=null;
        Conexion conexion = new Conexion();
        try(Connection connection = conexion.obtenerConexion();
                PreparedStatement ps = connection.prepareCall(consulta);){
                rs=ps.executeQuery();
                while(rs.next()){
                    BeanUsuario us = new BeanUsuario();
                    us.setIdUsuario(rs.getInt("idUsuario"));
                    us.setNombre(rs.getString("nombre"));
                    us.setApellido(rs.getString("apellido"));
                    us.setDocumento(rs.getString("documento"));
                    us.setCelular(rs.getString("celular"));
                    listaUsu.add(us);
                }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return listaUsu=null;
        }
        return listaUsu;
    }

    @Override
    public BeanUsuario list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(BeanUsuario Usu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(BeanUsuario Usu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

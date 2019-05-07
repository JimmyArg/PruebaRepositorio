/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testWebb.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SQA
 */
public class Conexion {
    
    String url,user,pass,driver, db;
    Connection conexion;
    
    public Conexion(){
        
    }
    
    public Connection obtenerConexion(){
        user="root";
        pass="";
        db="testWebDb";
        
        driver="com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/" + db+"?zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url,user,pass);
            System.out.println("Ok.");
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
        return conexion;
    }
    
    public static void main(String[] args) {
        Conexion con= new Conexion();
        con.obtenerConexion();
    }
    
}

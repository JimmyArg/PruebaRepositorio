/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testWebb.interfacee;

import com.testWebb.bean.BeanUsuario;
import java.util.List;

/**
 *
 * @author SQA
 */
public interface CRUD {
    public List listar();
    public BeanUsuario list(int id);
    public boolean add(BeanUsuario Usu);
    public boolean edit(BeanUsuario Usu);
    public boolean eliminar(int id);
}

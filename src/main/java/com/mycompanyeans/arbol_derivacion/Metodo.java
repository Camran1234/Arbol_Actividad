/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyeans.arbol_derivacion;

/**
 *
 * @author camran1234
 */
public class Metodo {
    private String nombre="";
    private String parametro="";
    
    public Metodo(String nombre){
        this.nombre = nombre;
    }
    
    public void setParam(String parametro){
        this.parametro = parametro;
    }
    
    /**
     * Retorna el nombre del metodo con el que fue invocado
     * @return 
     */
    public String getMethodCall(){
        return nombre+"("+parametro+")";
    }
    
    public String getName(){
        return nombre;
    }
}
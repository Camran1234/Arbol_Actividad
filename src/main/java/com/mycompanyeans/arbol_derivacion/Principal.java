/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyeans.arbol_derivacion;

import java.util.ArrayList;

/**
 *
 * @author camran1234
 */
public class Principal {
    ArrayList<Metodo> metodos = new ArrayList();
    String name = "";
    static int identificador=0;
    
    public Principal(ArrayList<Metodo> metodos, String name){
        /*Le damos la vuelta porque vienen en post orden*/
        for(int index=metodos.size()-1; index>=0; index--){
            this.metodos.add(metodos.get(index));
        }
        this.name = name;
    }
    
    public ArrayList<Metodo> getMetodos(){
        return this.metodos;
    }
    
    public String getName(){
        return name;
    }
    
    /**
     * El arrayList de funciones indica todas las funciones que existen en el contexto
     * 
     * @param funciones
     * @return 
     */
    public String execute(ArrayList<Funcion> funciones, String label){
        StringBuffer string = new StringBuffer();
        for(int index=0; index<metodos.size(); index++){
            Metodo metodo = metodos.get(index);
            for(int indexProceso=0; indexProceso<funciones.size(); indexProceso++){
                if(metodo.getName().equals(funciones.get(indexProceso).getName())){
                    identificador++;
                    String nombre = metodo.getName()+identificador;
                    string.append(nombre+ "[ label=\""+metodo.getMethodCall()+"\" ];\n");
                    string.append(label + " -> " +nombre+"\n");
                    string.append(funciones.get(indexProceso).execute(funciones,nombre));
                    break;
                }
            }
        }
        
        return string.toString();
    }
    
}

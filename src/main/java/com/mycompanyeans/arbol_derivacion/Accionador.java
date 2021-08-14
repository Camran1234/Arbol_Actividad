/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyeans.arbol_derivacion;
import com.mycompanyeans.parser.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
/**
 *
 * @author camran1234
 */
public class Accionador {
    
    /**
     * Devuelve el codigo de graphviz de la cadena introducida
     * @param text
     * @return
     * @throws Exception 
     */
    public String Accionar(String text) throws Exception{
        StringBuffer string = new StringBuffer();
        StringReader reader = new StringReader(text);
        Lexic lexico = new Lexic(reader);
        parser parser = new parser(lexico);
        parser.parse();
        Principal principal = parser.getPrincipal();
        ArrayList<Funcion> procedimientos = parser.getProcedimientos();
        string.append("digraph G { \n");
        string.append("principal0 [ label=\"PRINCIPAL\" ];\n");
        string.append(principal.execute(procedimientos, "principal0"));
        string.append("}");
        System.out.println(string.toString());
        return string.toString();
    }
    
    public void generar(String codigo, String path){
       
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path))){
            //Reading file
            br.append(codigo);
            br.close();
        }catch(Throwable e){
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        if(new File(path).getName().contains(".png")){
            executeGraphviz(new File(path), new File(path).getName());
        }else{
            executeGraphviz(new File(path), new File(path).getName()+".png");
        }
    }
    private void executeGraphviz(File file, String outPutName){
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder( "dot", "-Tpng",file.getAbsolutePath(), "-o",   file.getParent()+"/"+outPutName);
            pbuilder.redirectErrorStream( true );
            //Ejecuta el proceso
            pbuilder.start();
            
            System.out.println("\nSe creo tu imagen "+ outPutName);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error en executeGraphviz: "+ex.getMessage());
        }
    } 
    
}

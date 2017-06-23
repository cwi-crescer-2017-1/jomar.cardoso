/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Jomar
 */
public class LeituraImpl {   
    
    public String read(String string) {
        String retorno = "";
        try (   final Reader reader = new FileReader(LeituraImpl.isArquivo(string)); 
                final BufferedReader bufferReader = new BufferedReader(reader);) { 

            while (true) { 
                try{
                    final String readLine = bufferReader.readLine();    
                    if(readLine == null) {
                        break;
                    }
                    
                    retorno = retorno.concat(readLine + " "); 
                }
                catch (NullPointerException e){
                     break;
                }                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }           
        System.out.println(retorno);
        return retorno.trim();
    }

    private boolean isEmpty(String string) {        
        return string == null || string.trim().isEmpty(); 
    }
    
    private static String isArquivo(String string) throws IOException {
        if(string.endsWith(".sql")) {
            return string;            
        }
        throw new IOException();
    }
    
     public static void main(String[] args) {       
        LeituraImpl readerUtils = new LeituraImpl();
        System.out.println(readerUtils.read("file/leitura.sql"));
    }
    
}

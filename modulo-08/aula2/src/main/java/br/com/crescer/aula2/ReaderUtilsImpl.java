/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import br.com.crescer.aula1.MeuString;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Jomar
 */
public class ReaderUtilsImpl implements ReaderUtils{
    
    //O método read receba o nome do arquivo e exiba seu conteúdo.
    @Override
    public String read(String string) {
        String retorno = "";
        try (   final Reader reader = new FileReader(FileUtilsImpl.isArquivo(string)); 
                final BufferedReader bufferReader = new BufferedReader(reader);) { 
            //if(string.contains("/(\.txt)$/i"))
            //if(!FileUtilsImpl.isArquivo(string)) {
            //    throw new IOException();
            //}
            while (true) { 
                try{
                    final String readLine = bufferReader.readLine();
                    if (!new MeuString().isEmpty(readLine)) { 
                        retorno = retorno.concat(readLine + " "); 
                    }                     
                }
                catch (NullPointerException e){
                     break;
                }                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }           
        return retorno.trim();
    }
    
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtilsImpl();        
        ReaderUtils readerUtils = new ReaderUtilsImpl();
        System.out.println(readerUtils.read("file/leitura.txt"));
    }
    
}

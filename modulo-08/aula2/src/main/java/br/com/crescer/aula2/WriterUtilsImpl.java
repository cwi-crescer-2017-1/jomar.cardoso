/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import br.com.crescer.aula1.MeuString;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Jomar
 */
public class WriterUtilsImpl implements WriterUtils{

    @Override
    public void write(String file, String conteudo) {
        try (   final FileWriter fileWriter = new FileWriter(FileUtilsImpl.isArquivo(file), true); 
                final BufferedWriter bufferedWriter  = new BufferedWriter(fileWriter);) { 
            bufferedWriter.newLine(); 
            bufferedWriter.append(conteudo);            
            bufferedWriter.flush(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
        System.out.println("OK");
    }
    
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtilsImpl();        
        WriterUtils writerUtils = new WriterUtilsImpl();
        writerUtils.write("file/leitura.txt", "outra linha");
    }

    
}

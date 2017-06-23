/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

import java.io.File;

/**
 *
 * @author Jomar
 */
public interface SQLUtils {

    void runFile(String filename);
    String executeQuery(String query);    
    void importCSV(File file, String tabela);    
    File exportCSV(String query, String arquivo);

}
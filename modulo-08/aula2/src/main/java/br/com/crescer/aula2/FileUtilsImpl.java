/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;

/**
 *
 * @author jomar.cardoso
 */
public class FileUtilsImpl implements FileUtils{

    //O método mk deve criar um arquivo ou diretório.
    @Override
    public boolean mk(String string) {
        try {
            return new File(string).createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //O método rm deve excluir o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    @Override
    public boolean rm(String string) {
        File file = new File(string);
        return file.delete();
    }

    //O método ls deve mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos.
    @Override
    public String ls(String string) {
        return new File("aula2.txt").getAbsolutePath();
    }

    //O método mv deve mover o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    @Override
    public boolean mv(String in, String out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtilsImpl();
        System.out.println("criar: " + fileUtils.mk("aula2.txt"));
        System.out.println("apagar: " + fileUtils.ls("aula2.txt"));
        System.out.println("apagar: " + fileUtils.rm("aula2.txt"));        
    }
}

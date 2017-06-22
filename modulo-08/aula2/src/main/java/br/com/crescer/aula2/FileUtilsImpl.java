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
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author jomar.cardoso
 */
public class FileUtilsImpl implements FileUtils{

    //O método mk deve criar um arquivo ou diretório.
    @Override
    public boolean mk(String string) {
        try {
            if(string.contains(".")){
                return new File(string).createNewFile();
            }
            return new File(string).mkdir();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //O método rm deve excluir o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    @Override
    public boolean rm(String string) {
        File file = new File(string);
        if(file.isDirectory()) {  
            System.out.println("Envie um arquivo");             
        }
        return file.delete();
    }

    //O método ls deve mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos.
    @Override
    public String ls(String string) {
        File file = new File(string);
        if(file.isDirectory()) {
            return String.join(", ", file.list());
        }
        return file.getAbsolutePath();
    }

    //O método mv deve mover o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
    @Override
    public boolean mv(String in, String out) {
        new File(in).delete();
        File source = new File(in);
        if(source.isDirectory()) {  
            System.out.println("Envie um arquivo");             
        } else {
            if(source.renameTo(new File(out + source.getName()))){
                return true;
            }else{
    		System.out.println("Erro ao mover");
            } 
        }
        return false;
    }
    
    public static String isArquivo(String string) throws IOException {
        if(string.endsWith(".txt")) {
            return string;            
        }
        throw new IOException();
    }
    
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtilsImpl();
        //System.out.println("criar: " + fileUtils.mk("doce"));
        //System.out.println("caminho: " + fileUtils.ls("file"));
        //System.out.println("apagar: " + fileUtils.rm("file/aula2.txt"));
        //System.out.println("criar: " + fileUtils.mk("file/aulaMovida.txt"));
        //System.out.println("mover: " + fileUtils.mv("file/aulaMovida.txt", "file/move/"));
    }
}

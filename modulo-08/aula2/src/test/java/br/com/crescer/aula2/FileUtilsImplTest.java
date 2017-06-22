/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jomar
 */
public class FileUtilsImplTest {
    
    private final FileUtilsImpl instance = new FileUtilsImpl();    
    private final String stringArquivo = "file/teste/teste.txt";
    private final String stringPasta = "file/teste/";
    
    private final File arquivao = new File(stringArquivo);
    
    public FileUtilsImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testa criar um arquivo válido
     */
    @Test
    public void testCriarArquivoValido() throws IOException {      
        boolean expResult = true;
        File pasta = new File(stringPasta);
        pasta.mkdir();
        
        boolean result = instance.mk(stringArquivo);
        assertEquals(expResult, result);
        
        File file = new File(stringArquivo);
        assertEquals(expResult, file.isFile());
               
        pasta.deleteOnExit();
    }
    
    /**
     * Testa criar uma pasta
     */
    @Test
    public void testCriarPasta() {      
        boolean expResult = true;
        
        boolean result = instance.mk(stringPasta);
        assertEquals(expResult, result);
        
        File file = new File(stringPasta);
        assertEquals(expResult, file.isDirectory());
              
        file.delete();
    }
    
     /**
     * Testa criar um arquivo inválido
     */
    @Test
    public void testCriarArquivoInvalido() {      
        boolean expResult = false;
        
        boolean result = instance.mk("");
        assertEquals(expResult, result);
        
        File file = new File("");
        assertEquals(expResult, file.isFile());
               
        file.delete();
    }

    /**
     * Teste remover
     */
    @Test
    public void testeRemoverValido() throws IOException {     
        boolean expResult = true;
        new File(stringPasta).createNewFile();
        new File(stringArquivo).createNewFile();
        
        boolean result = instance.rm(stringArquivo);
        assertEquals(expResult, result);        
    }
    
    /**
     * Teste remover inválido
     */
    @Test
    public void testeRemoverInvalido() {      
        boolean expResult = false;
        
        boolean result = instance.rm(stringArquivo);
        assertEquals(expResult, result);        
    }

    /**
     * Test of ls method, of class FileUtilsImpl.
     */
    @Test
    public void testCaminhoDeArquivo() throws IOException {
        String string = "c:/temp/teste.txt";
        String expResult = "c:\\temp\\teste.txt";     
        File file = new File(string);
        file.createNewFile();
        
        String result = instance.ls(string);
        assertEquals(expResult, result);

        file.delete();
    }
    
        /**
     * Test of ls method, of class FileUtilsImpl.
     */
    @Test
    public void testArquivosNaPasta() throws IOException {
        File pasta = new File(stringPasta);
        pasta.mkdir();
        File arquivo1 = new File(stringArquivo + "1");
        arquivo1.createNewFile();
        File arquivo2 = new File(stringArquivo + "2");
        arquivo2.createNewFile();        
        String expResult = "teste.txt1, teste.txt2"; 
        
        String result = instance.ls(stringPasta);        
        assertEquals(expResult, result);

        arquivo1.deleteOnExit();
        arquivo2.deleteOnExit();
        pasta.delete();
        pasta.deleteOnExit();
    }    

    /**
     * Test of mv method, of class FileUtilsImpl.
     */
    @Test
    public void testMover() throws IOException {
        File pasta1 = new File(stringPasta);
        pasta1.mkdir();
        File arquivo = new File(stringArquivo);
        arquivo.createNewFile();
        File pasta2 = new File(stringPasta + "teste/");
        pasta2.mkdir();        
        boolean expResult = true;
        String expResult2 = "/(teste\\\\\\\\teste\\\\\\\\teste.txt)$/i";
        
        boolean result = instance.mv(stringArquivo, stringPasta + "teste/");
        assertEquals(expResult, result);
            
        String result2 = arquivo.getAbsolutePath();
        assertTrue(result2.endsWith(expResult2));
        System.out.println("");
    }

    /**
     * Test of isArquivo method, of class FileUtilsImpl.
     */
    @Test
    public void testIsArquivo() throws IOException {
        new File(stringArquivo).delete();
        new File(stringPasta).delete();
        String string = "arquivo.txt";
        String expResult = "arquivo.txt";
        String result = FileUtilsImpl.isArquivo(string);
        
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isArquivo method, of class FileUtilsImpl.
     */
    @Test(expected = IOException.class)
    public void testIsArquivoInvalido() throws IOException {
        new File(stringArquivo).delete();
        new File(stringPasta).delete();
        String string = "arquivo.exe";
        String expResult = "arquivo.txt";
        String result = FileUtilsImpl.isArquivo(string);
    }
     
}

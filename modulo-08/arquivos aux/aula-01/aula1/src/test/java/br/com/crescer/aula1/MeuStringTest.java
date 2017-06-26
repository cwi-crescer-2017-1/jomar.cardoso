/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertTrue; 
import org.junit.Test;
 

/**
 *
 * @author Jomar
 */
public class MeuStringTest {    
    private final MeuString meuString;
 
    public MeuStringTest() { 
        this.meuString = new MeuString(); 
    }
 

 
    /**
 
     * Test of isEmpty method, of class StringUtils.
 
     */
 
    @Test
 
    public void testIsEmpty() {
 
        assertTrue(meuString.isEmpty(null));
 
        assertTrue(meuString.isEmpty(""));
 
        assertTrue(meuString.isEmpty(" "));
 
        assertFalse(meuString.isEmpty("a"));
 
        assertFalse(meuString.isEmpty(" a "));
 
    }
 

 
    /**
 
     * Test of inverter method, of class StringUtils.
 
     */
 
    @Test
 
    public void testInverter() {
 
        assertEquals("solrac", meuString.inverter("carlos"));
 
    }
 

 
    /**
 
     * Test of contaVogais method, of class StringUtils.
 
     */
 
    @Test
 
    public void testContaVogais() {
 
        assertEquals(2, meuString.contaVogais("carlos"));
 
    }
 

 
    /**
 
     * Test of isPalindromo method, of class StringUtils.
 
     */
 
    @Test
 
    public void testIsPalindromo() {
 
        assertTrue(meuString.isPalindromo("ovo"));
 
        assertTrue(meuString.isPalindromo("Ame a Ema"));
 
        assertTrue(meuString.isPalindromo("A sogra má e amargosa"));
 
        assertFalse(meuString.isPalindromo("uva"));
 
        assertFalse(meuString.isPalindromo("Ame a Emo"));
 
    }
 
    
}

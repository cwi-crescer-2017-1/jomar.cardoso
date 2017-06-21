/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.text.Normalizer;

/**
 *
 * @author Jomar
 */
public class MeuString implements StringUtils {

    //O método isEmpty deve validar se a string está nula e vazia.
    @Override
    public boolean isEmpty(String string) {        
        if(string.isEmpty()) {
            return true;
        }
        return false;
    }

    //O método inverter deve inverter uma string caso a mesma não estiver vazia, exemplo - carlos > solrac
    @Override
    public String inverter(String string) {
        if (isEmpty(string)) {
            return null;
        }
        return new StringBuilder(string).reverse().toString();
    }

    //O método contarVogais que conte o nº de vogais da String (a,e,i,o,u), exemplo - carlos > 2
    @Override
    public int contaVogais(String string) {
        if (isEmpty(string)) {
            return 0;
        }
        int total_vogais = 0;
        for(int i = 0; i < string.length(); i++){
            if      (string.charAt(i)=='a'
                    || string.charAt(i)=='e'
                    ||string.charAt(i)=='i'
                    || string.charAt(i)=='o'
                    || string.charAt(i)=='u'
                    || string.charAt(i)=='A'
                    || string.charAt(i)=='E'
                    ||string.charAt(i)=='I'
                    || string.charAt(i)=='O'
                    || string.charAt(i)=='U' ) {
                total_vogais++;
            }        
        }
        return total_vogais;
        //se der tempo vou mudar para reg exp
    }
    
    //O método isPalindromo deve identificar se a string é um palíndromo, ou seja se quando invertida ela tem os mesmos 
    //caracteres sem os espaços, acentuação e case sensitive, exemplo - "ovo", "Ame a ema", "A sogra má e amargosa")
    @Override
    public boolean isPalindromo(String string) {
    if (isEmpty(string)) {
        return false;
    }
    string = normalize(string.trim());
    if( string.compareToIgnoreCase(inverter(string)) == 0) {
        return true;
    }
    return false;
    }
    
    private static String normalize(String nome) { 
        return Normalizer.normalize(nome, Normalizer.Form.NFD) 
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); 
    }
}

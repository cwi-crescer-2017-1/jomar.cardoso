/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 * @author Jomar
 */
public class MeuParcelador implements Parcelator{

    
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyyy"); 
    private static final Calendar CALENDAR = Calendar.getInstance();
 

 
    @Override 
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        final BigDecimal qtdParcelas = BigDecimal.valueOf(numeroParcelas);
        final BigDecimal multiplicador = BigDecimal.valueOf(taxaJuros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
        final BigDecimal vlTotal = valorParcelar.multiply(multiplicador);
        final BigDecimal vlParcela = vlTotal.divide(qtdParcelas, 2, RoundingMode.HALF_UP);
 
        BigDecimal vlResto = vlParcela.multiply(qtdParcelas).subtract(vlTotal);
        final Map<String, BigDecimal> map = new LinkedHashMap<>();
        CALENDAR.setTime(dataPrimeiroVencimento);
        for (int i = 0; i < numeroParcelas; i++) { 
            map.put(DATE_FORMAT.format(CALENDAR.getTime()), vlParcela.subtract(vlResto)); 
            vlResto = BigDecimal.ZERO; 
            CALENDAR.add(Calendar.MONTH, 1); 
        } 
        return map; 
    }
 
    
    public static void main(String[] args) throws ParseException {
        Parcelator parcelador = new MeuParcelador();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPrimeiroVencimento = (Date)formatter.parse("30/06/2016");        
        Map<String, BigDecimal> parcelamento = parcelador.calcular(BigDecimal.valueOf(1000), 10, 10, dataPrimeiroVencimento);
        
    
        for(Entry<String, BigDecimal> a : parcelamento.entrySet()){
            System.out.println(a.getKey() + " - " + a.getValue());
        }
    }
    
}

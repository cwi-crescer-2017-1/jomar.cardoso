/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 * @author Jomar
 */
public class MeuParcelador implements Parcelator{

    
    private static final Format FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        BigDecimal valorParcela = valorParcelar.divide(BigDecimal.valueOf(numeroParcelas));
        valorParcela = valorParcela.multiply((BigDecimal.valueOf(numeroParcelas).divide(BigDecimal.valueOf(100)))).add(valorParcela);
        Map<String, BigDecimal> retorno = new TreeMap<>();
        for(int i=0; i<numeroParcelas; i++) {
            Calendar dataParcela = Calendar.getInstance();  
            dataParcela.setTime(dataPrimeiroVencimento); 
            dataParcela.add(Calendar.MONTH, i);
            String stringData = FORMATTER.format(dataParcela.getTime());
            retorno.put(stringData, valorParcela);
        }
        return retorno;
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

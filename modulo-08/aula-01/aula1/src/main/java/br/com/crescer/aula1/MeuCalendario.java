/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jomar
 */
public class MeuCalendario implements CalendarUtils {

    //O método diaSemana recebe uma data e devolve o dia da semana conforme enum.
    @Override
    public DiaSemana diaSemana(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);        
        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                    return DiaSemana.DOMINGO;
            case 2:
                    return DiaSemana.SEGUNDA_FEIRA;
            case 3: 
                    return DiaSemana.TERCA_FEIRA;
            case 4:
                    return DiaSemana.QUARTA_FEIRA;
            case 5: 
                    return DiaSemana.QUINTA_FEIRA;
            case 6:
                    return DiaSemana.SEXTA_FEIRA;
            default:
                    return DiaSemana.SABADO;
            }
    }       
    
    //O método tempoDecorrido recebe uma data e devolve o tempo decorrido até a data atual no formato 30 ano(s), 3 messe(s) e 12 dia(s)
    @Override
    public String tempoDecorrido(Date date) {
        Calendar dataAntiga = Calendar.getInstance();  
        dataAntiga.setTime(date); 
        Calendar hoje = Calendar.getInstance();  
        int anos = hoje.get(Calendar.YEAR) - dataAntiga.get(Calendar.YEAR); 
        int meses = hoje.get(Calendar.MONTH) - dataAntiga.get(Calendar.MONTH);
        int dias = hoje.get(Calendar.DAY_OF_MONTH) - dataAntiga.get(Calendar.DAY_OF_MONTH);  
        if (hoje.get(Calendar.MONTH) < dataAntiga.get(Calendar.MONTH)) {
            anos--;  
        } 
            else 
        { 
            if (hoje.get(Calendar.MONTH) == dataAntiga.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataAntiga.get(Calendar.DAY_OF_MONTH)) {
                anos--;                 
            }
        }        
        if (hoje.get(Calendar.DAY_OF_MONTH) < dataAntiga.get(Calendar.DAY_OF_MONTH)) {
            meses--;  
            dias = 30 - (dataAntiga.get(Calendar.DAY_OF_MONTH) - hoje.get(Calendar.DAY_OF_MONTH));  
            //descobri que a forma que utilizei ocorrerá um erro aqui, pois os meses não tem apenas 30 dias
        } 
        return anos + " anos " + meses + " meses e " + dias + " dias" ;        
    }
    
    public static void main(String[] args) throws ParseException {
        
        System.out.println("verifica dia da semana");
        System.out.println(new MeuCalendario().diaSemana(new Date()));
        
        System.out.println("\ncalcula tempo decorrido");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date)formatter.parse("27/03/1991");
        System.out.println(new MeuCalendario().tempoDecorrido(date));
    }
    
}

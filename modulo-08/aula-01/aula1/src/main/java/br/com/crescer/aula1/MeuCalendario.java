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
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jomar
 */
public class MeuCalendario implements CalendarUtils {
    
    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final String TEMPLATE = "%s ano(s), %s messe(s) e %s dia(s)";
 

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
        CALENDAR.setTime(new Date(this.getHoraZero(new Date()).getTime() - this.getHoraZero(date).getTime())); 
        return String.format(TEMPLATE, (CALENDAR.get(YEAR) - 1970), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH));
        
    }
    
    private Date getHoraZero(Date date) { 
        CALENDAR.setTime(date); 
        CALENDAR.set(CALENDAR.get(YEAR), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH), 0, 0, 0); 
        return CALENDAR.getTime(); 
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

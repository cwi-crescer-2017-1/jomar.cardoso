

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GolpearTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GolpearTest
{
   @Test
   public void executarFeliz() throws Exception{
       Saint seya = new BronzeSaint("Seya", "Pégaso");
       Saint marin = new SilverSaint("Marin", "Águia");
       Saint mu = new GoldSaint("Mu", "Áries");
       Golpe soco = new Golpe("Soco", 8);
       seya.aprenderGolpe(soco);
       marin.aprenderGolpe(soco);
       mu.aprenderGolpe(soco);       
       
       Golpear golpe1 = new Golpear(seya, marin);
       golpe1.executar();
       assertEquals(92.0, marin.getVida(), 0.01);
       seya.vestirArmadura();
       golpe1.executar();
       assertEquals(76.0, marin.getVida(), 0.01);
       
       Golpear golpe2 = new Golpear(marin, mu);
       golpe2.executar();
       assertEquals(92.0, mu.getVida(), 0.01);
       marin.vestirArmadura();
       golpe2.executar();
       assertEquals(68.0, mu.getVida(), 0.01);
       
       Golpear golpe3 = new Golpear(mu, seya);
       golpe3.executar();
       assertEquals(92.0, seya.getVida(), 0.01);
       mu.vestirArmadura();
       golpe3.executar();
       assertEquals(60.0, seya.getVida(), 0.01);     
    }
}

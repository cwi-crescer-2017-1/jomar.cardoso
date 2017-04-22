

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
       VestirArmadura vestir1 = new VestirArmadura(seya);
       vestir1.executar();
       golpe1.executar();
       assertEquals(76.0, marin.getVida(), 0.01);
       
       Golpear golpe2 = new Golpear(marin, mu);
       golpe2.executar();
       assertEquals(92.0, mu.getVida(), 0.01);
       VestirArmadura vestir2 = new VestirArmadura(marin);
       vestir2.executar();
       golpe2.executar();
       assertEquals(68.0, mu.getVida(), 0.01);
       
       Golpear golpe3 = new Golpear(mu, seya);
       golpe3.executar();
       assertEquals(92.0, seya.getVida(), 0.01);
       VestirArmadura vestir3 = new VestirArmadura(mu);
       vestir3.executar();
       golpe3.executar();
       assertEquals(60.0, seya.getVida(), 0.01);     
    }
}

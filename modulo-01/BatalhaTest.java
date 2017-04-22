import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {    
    @Test
    public void pelearAteMorrer() throws Exception{
       Saint seya = new BronzeSaint("Seya", "Pégaso");
       Saint marin = new SilverSaint("Marin", "Águia");
       Golpe soco = new Golpe("Soco", 8);
       seya.aprenderGolpe(soco);
       marin.aprenderGolpe(soco);
       Batalha batalha1 = new Batalha(seya, marin);
       batalha1.iniciar();
       assertEquals(Status.VIVO, marin.getStatus());
       assertEquals(Status.MORTO, seya.getStatus());
    }
}
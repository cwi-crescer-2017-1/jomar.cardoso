import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ConstelacaoTest {

    @Test
    public void adicionarUmGolpe() {
        Constelacao gemeos = new Constelacao("GÍmeos");
        Golpe outraDimensao = new Golpe("Outra dimens„o", 10);
        gemeos.adicionarGolpe(new Golpe("Outra dimens„o", 10));
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        //assertNull(golpes.get(1));
        //assertNull(golpes.get(2));
        // TODO: assert null
    }

    @Test
    public void adicionarDoisGolpes() {
        Constelacao gemeos = new Constelacao("GÍmeos");
        Golpe outraDimensao = new Golpe("Outra dimens„o", 10);
        Golpe explosaoGalatica = new Golpe("Explos√£o Gal·ctica", 11);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        //assertNull(golpes.get(2));
    }

    @Test
    public void adicionarTresGolpes() {
        Constelacao gemeos = new Constelacao("G meos");
        Golpe outraDimensao = new Golpe("Outra dimens„o", 10);
        Golpe explosaoGalatica = new Golpe("Explos„o Gal·ctica", 11);
        Golpe sataImperial = new Golpe("Sat„ Imperial", 60);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(sataImperial, golpes.get(2));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void adicionarQuatroGolpesEVerificarExceptionConsultarOQuinto(){
        Constelacao gemeos = new Constelacao("GÍmeos");
        Golpe outraDimensao = new Golpe("Outra dimens√o", 10);
        Golpe explosaoGalatica = new Golpe("Explos√£o Gal·ctica", 11);
        Golpe sataImperial = new Golpe("Sat„ Imperial", 60);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);
        gemeos.adicionarGolpe(new Golpe("CÛlera do cafÈ intenso", 80));
        ArrayList<Golpe> golpes = gemeos.getGolpes();
        assertNull(golpes.get(4));
    }

}












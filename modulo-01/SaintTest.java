import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.OURO);
        Saint milo = new GoldSaint("Milo", escorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", new Armadura(new Constelacao("Unicórnio"), Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }

    @Test
    public void statusInicialDeveSerVivo() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        assertEquals(Status.VIVO, shiryu.getStatus());
    }

    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor10() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(10);
        // Assert
        assertEquals(90, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor100() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(100);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor1000() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(1000);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", new Armadura(new Constelacao("Dragão"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(-1000);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", new Armadura(new Constelacao("Águia"), Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura(new Constelacao("Café"), Categoria.OURO));
    }

    @Test
    public void aprenderUmGolpe() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        ArrayList<Golpe> golpes = saga.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(1, golpes.size());
        // TODO: assert null
    }

    @Test
    public void aprenderDoisGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        ArrayList<Golpe> golpes = saga.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(2, golpes.size());
    }

    @Test
    public void aprenderTresGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        ArrayList<Golpe> golpes = saga.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(sataImperial, golpes.get(2));
    }

    @Test
    public void aprenderQuatroGolpes() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        Golpe rasteira = new Golpe("Rasteira", 2);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        saga.aprenderGolpe(rasteira);
        ArrayList<Golpe> golpes = saga.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosaoGalatica, golpes.get(1));
        assertEquals(sataImperial, golpes.get(2));
        assertEquals(rasteira, golpes.get(3));
    }

    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComQuatroChamadas() throws Exception {
        Saint saga = new GoldSaint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getCSVComArmaduraVestida() throws Exception {
        Saint dohko = new GoldSaint("Dohko", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        dohko.perderVida(90);
        dohko.vestirArmadura();
        String esperado = "Dohko,10.0,Gêmeos,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, dohko.getCSV());
    }

    @Test
    public void getCSVSemArmaduraVestida() throws Exception {
        Saint june = new BronzeSaint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }
    
    @Test
    public void getCSVComNomeNulo() throws Exception {
        Saint june = new BronzeSaint(null, new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "null,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }

}








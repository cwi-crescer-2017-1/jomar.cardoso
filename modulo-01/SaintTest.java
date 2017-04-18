import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura(new Constelacao("Touro"), Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Touro"), Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new Saint("Jabu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }

    @Test
    public void statusInicialDeveSerVivo() throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(Status.VIVO, shiryu.getStatus());
    }

    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor10() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(10);
        // Assert
        assertEquals(90, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor100() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(100);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor1000VidaNaoFicaNegativo() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(1000);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test(expected=Exception.class)
    public void perderDanoComValorMenos1000() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        // Act
        shiryu.perderVida(-1000);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", new Armadura(new Constelacao("Touro"), Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Touro"), Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura(new Constelacao("Toura"), Categoria.OURO));
    }
    
    @Test
    public void atacarAteMorrerETentarContinuarAtacando() throws Exception{
        //Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura(new Constelacao("Touro"), Categoria.BRONZE));
        //Act
        shiryu.perderVida(80);
        // Assert
        assertEquals(Status.VIVO, shiryu.getStatus());
        assertEquals(20, shiryu.getVida(), 0.01);
        // Act
        shiryu.perderVida(30);
        // Assert
        assertEquals(Status.MORTO, shiryu.getStatus());
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarConstelacaoArmaduraSaintEAdicionarGolpe() throws Exception {
        // Arrange
        Constelacao aries = new Constelacao("Áries");
        Armadura roxa = new Armadura(aries, Categoria.OURO); 
        Saint jomar = new Saint("Jomar", roxa);
        Golpe socoo = new Golpe("Soco", 6);
        Golpe chute = new Golpe("Chute", 7);
        Golpe cabecada = new Golpe("Cabecada", 8);
        // Act
        aries.adicionarGolpe(socoo);
        aries.adicionarGolpe(chute);
        aries.adicionarGolpe(cabecada);  
        // Arrange
        String stringSoco = jomar.getArmadura().getConstelacao().getGolpes()[0].getNome();
        String stringChute = jomar.getArmadura().getConstelacao().getGolpes()[1].getNome();
        String stringCabecada = jomar.getArmadura().getConstelacao().getGolpes()[2].getNome();
         // Assert     
        assertEquals(stringSoco, "Soco");
        assertEquals(stringChute, "Chute");
        assertEquals(stringCabecada, "Cabecada");
    }
}









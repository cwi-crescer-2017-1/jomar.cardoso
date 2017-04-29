import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemAlternadaTest
{
    @Test
    public void adiciona2Gold3Bronze1Silver() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));
        
        Saint saint = defensoresDeAthena.getProximoSaint();
        Categoria categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.BRONZE, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.OURO, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.BRONZE, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.OURO, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.BRONZE, categoria);
    }
    
    @Test
    public void naoAdicionaETentaPegarSaint() {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
        Saint saint = defensoresDeAthena.getProximoSaint();
        assertNull(saint);
    }
    
    @Test
    public void adiciona6Silver() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
        defensoresDeAthena.alistar(new SilverSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new SilverSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new SilverSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new SilverSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new SilverSaint("Shiryu", "Dragão"));
        
        Saint saint = defensoresDeAthena.getProximoSaint();
        Categoria categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
    }
    
     @Test
    public void adiciona6Silver1Bronze() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
        defensoresDeAthena.alistar(new SilverSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new SilverSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new SilverSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new BronzeSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new SilverSaint("Shiryu", "Dragão"));
        
        Saint saint = defensoresDeAthena.getProximoSaint();
        Categoria categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.BRONZE, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
    }
    
    @Test
    public void adiciona1Bronze6Silver() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
        defensoresDeAthena.alistar(new BronzeSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new SilverSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new SilverSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new SilverSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new SilverSaint("Shiryu", "Dragão"));
        
        Saint saint = defensoresDeAthena.getProximoSaint();
        Categoria categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.BRONZE, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
    }
    
        @Test
    public void adiciona1Gold6Silver() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new SilverSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new SilverSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new SilverSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new SilverSaint("Shiryu", "Dragão"));
        
        Saint saint = defensoresDeAthena.getProximoSaint();
        Categoria categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.OURO, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
    }
    
            @Test
    public void adiciona6Silver2Gold() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Áries"));
        defensoresDeAthena.alistar(new SilverSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new SilverSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new SilverSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new GoldSaint("Shiryu", "Capricórnio"));
        
        Saint saint = defensoresDeAthena.getProximoSaint();
        Categoria categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.OURO, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.OURO, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
        
        saint = defensoresDeAthena.getProximoSaint();
        categoria = saint.getArmadura().getCategoria();
        assertEquals(Categoria.PRATA, categoria);
    }
}

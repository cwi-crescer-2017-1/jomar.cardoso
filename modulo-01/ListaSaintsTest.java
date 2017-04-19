

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void adicionar() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        // Act
        lista.adicionarSaint(saga);
        // Assert
        assertEquals(lista.getSaint(0), saga);        
    }

    @Test
    public void adicionar2Saints() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        // Act
        lista.adicionarSaint(saga);
        lista.adicionarSaint(afrodite);
        // Assert
        assertEquals(lista.getSaint(0), saga);
        assertEquals(lista.getSaint(1), afrodite);        
    }
    
     @Test(expected=IndexOutOfBoundsException.class)
    public void adicionar2SaintsEVerificarPosicao3() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        // Act
        lista.adicionarSaint(saga);
        lista.adicionarSaint(afrodite);
        // Assert
        assertEquals(lista.getSaint(0), saga);
        assertEquals(lista.getSaint(1), afrodite);
        assertNull(lista.getSaint(2));
    }
    
    @Test
    public void buscarPorNomeValido() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(saga);
        lista.adicionarSaint(afrodite);
        // Act
        String nome = lista.buscarPorNome("Afrodite").getNome();
        // Assert
        assertEquals(nome, "Afrodite");
    }
    
    @Test
    public void todosSaints() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        GoldSaint jorge = new GoldSaint("Jorge", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(saga);
        lista.adicionarSaint(afrodite);
        lista.adicionarSaint(jorge);
        // Act
        ArrayList<Saint> todos = lista.todosSaints();
        // Assert        
        assertEquals(todos.get(0), saga);
        assertEquals(todos.get(1), afrodite);
    }
    
    /*
    @Test
    public void buscarPorNomeInvalido() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(saga);
        lista.adicionarSaint(afrodite);
        // Act
        String nome = lista.buscarPorNome("Afroditota").getNome();
        // Assert        
        assertEquals(nome, "null");
    } */
    
        @Test
    public void removerSaint() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        GoldSaint jorge = new GoldSaint("Jorge", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        lista.adicionarSaint(saga);
        lista.adicionarSaint(afrodite);
        lista.adicionarSaint(jorge);
        // Act
        lista.removerSaint(afrodite);
        ArrayList<Saint> todos = lista.todosSaints();
        // Assert        
        assertEquals(todos.get(0), saga);
        assertEquals(todos.get(1), jorge);
    }
}






















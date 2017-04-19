

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSaintsTest
{
    @Test
    public void adicionar() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        // Act
        lista.adicionar(saga);
        // Assert
        assertEquals(lista.get(0), saga);        
    }

    @Test
    public void adicionar2Saints() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        // Act
        lista.adicionar(saga);
        lista.adicionar(afrodite);
        // Assert
        assertEquals(lista.get(0), saga);
        assertEquals(lista.get(1), afrodite);        
    }
    
     @Test(expected=IndexOutOfBoundsException.class)
    public void adicionar2SaintsEVerificarPosicao3() throws Exception{
        // Arrange
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura(new Constelacao("Peixes"), Categoria.OURO));
        ListaSaints lista = new ListaSaints();
        // Act
        lista.adicionar(saga);
        lista.adicionar(afrodite);
        // Assert
        assertEquals(lista.get(0), saga);
        assertEquals(lista.get(1), afrodite);
        assertNull(lista.get(2));
    }
}

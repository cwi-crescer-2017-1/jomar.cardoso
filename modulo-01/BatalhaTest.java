

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste BatalhaTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class BatalhaTest
{
       @Test
  public void testarPrimeiroAtaqueEVerificarSePerdeuVida(){
      /// AAA
      // 1. Arrange - Montagem dos dados de teste
      Armadura escorpiao = new Armadura("Escorpiao", Categoria.PRATA);
      Armadura abutre = new Armadura("Abutre", Categoria.OURO);
      Saint jomar = new Saint("Jomar", escorpiao);      
      Saint zeca = new Saint("Zeca", abutre);
      Saint joca = new Saint("Joca", escorpiao);
      Batalha batalha1 = new Batalha(jomar, zeca);
      Batalha batalha2 = new Batalha(joca, jomar);
      Batalha batalha3 = new Batalha(zeca, joca);
      // 2. Act - Invocar a ação a ser testada
      batalha1.iniciar();
      batalha2.iniciar();
      batalha3.iniciar();
      // 3. Assert - Verificação dos resultados do teste
      jomar.getVida();
      assertEquals(jomar.getVida(), 80, 0.01);
      assertEquals(zeca.getVida(), 100, 0.01);
      assertEquals(joca.getVida(), 90.004, 0.01);
  }
}


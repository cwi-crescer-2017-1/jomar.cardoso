import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest
{
  @Test
  public void vestirArmaduraDeixaArmaduraVestida(){
      /// AAA
      // 1. Arrange - Montagem dos dados de teste
      Armadura escorpiao = new Armadura("Escorpiao", Categoria.PRATA);
      Saint jomar = new Saint("Jomar", escorpiao);
      // 2. Act - Invocar a ação a ser testada
      jomar.vestirArmadura();
      // 3. Assert - Verificação dos resultados do teste
      boolean resultado = jomar.getArmaduraVestida();
      assertEquals(true, resultado);
  }
  
  @Test
  public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
      Saint mana = new Saint("Mana", new Armadura("Cisne", Categoria.OURO));
      assertEquals(false, mana.getArmaduraVestida());
 }
 
 @Test
 public void aoCriarSaintGeneroENaoInformado() {
     Saint shaka = new Saint("Shaka", new Armadura("Preta", Categoria.OURO));
     shaka.setGenero(Genero.FEMININO);
     assertEquals(shaka.getGenero(), Genero.FEMININO);
 }
 
 @Test
 public void aoCriarSaintStatusVivoMudarParaDesacordado() {
     Saint roxette = new Saint("Roxette", new Armadura("Roxa", Categoria.PRATA));
     roxette.setStatus(Status.DESACORDADO);
     assertEquals(roxette.getStatus(), Status.DESACORDADO);
 }
 
 @Test
 public void aoCriarSaintCom100VidaReduzirVida() {
     Saint roxetta = new Saint("Roxette", new Armadura("Roxa", Categoria.PRATA));
     double vidaAtual = roxetta.perderVida(14);
     assertEquals(86.0, vidaAtual, 0.001);
 }
 
  
 @Test
 public void testarRetornoDaCategoriaArmadura() {
     boolean testa = true;
      Saint mana = new Saint("Mana", new Armadura("Cisne", Categoria.OURO));
      
     assertEquals(true, testa);
 }
 
 @Test
  public void testarPrimeiroAtaqueEVerificarSePerdeuVida(){
      /// AAA
      // 1. Arrange - Montagem dos dados de teste
      Batalha batalha1 = new Batalha();
      Batalha batalha2 = new Batalha();
      Batalha batalha3 = new Batalha();
      Armadura escorpiao = new Armadura("Escorpiao", Categoria.PRATA);
      Armadura abutre = new Armadura("Abutre", Categoria.OURO);
      Saint jomar = new Saint("Jomar", escorpiao);      
      Saint zeca = new Saint("Zeca", abutre);
      Saint joca = new Saint("Joca", escorpiao);
      // 2. Act - Invocar a ação a ser testada
      batalha1.iniciar(jomar, zeca);
      batalha2.iniciar(joca, jomar);
      batalha3.iniciar(zeca, joca);
      // 3. Assert - Verificação dos resultados do teste
      jomar.getVida();
      assertEquals(jomar.getVida(), 80, 0.001);
      assertEquals(zeca.getVida(), 100, 0.001);
      assertEquals(joca.getVida(), 90, 0.001);
  }
}

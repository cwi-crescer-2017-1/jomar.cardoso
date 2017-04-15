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
}

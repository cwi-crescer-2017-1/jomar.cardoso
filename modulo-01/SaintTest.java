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
 public void aoCriarSaintGeneroENaoInformadoEAlterarGenero() {
     Saint shaka = new Saint("Shaka", new Armadura("Preta", Categoria.OURO));
     assertEquals(shaka.getGenero(), Genero.NAO_INFORMADO);
     shaka.setGenero(Genero.FEMININO);
     assertEquals(shaka.getGenero(), Genero.FEMININO);
 }
 
 @Test
 public void aoCriarSaintStatusVivoMudarParaDesacordado() {
     Saint roxette = new Saint("Roxette", new Armadura("Roxa", Categoria.PRATA));
     assertEquals(roxette.getStatus(), Status.VIVO);
 }
 
 @Test
 public void aoCriarSaintCom100VidaReduzirVida() {
     Saint roxetta = new Saint("Roxetta", new Armadura("Roxa", Categoria.PRATA));
     assertEquals(100.005, roxetta.getVida(), 0.01);
     roxetta.perderVida(14);
     assertEquals(86.0, roxetta.getVida(), 0.01);
 }
 
  @Test
 public void perder100deVida() {
     Saint roxetta = new Saint("Roxetta", new Armadura("Roxa", Categoria.PRATA));
     roxetta.perderVida(100);
     assertEquals(0, roxetta.getVida(), 0.01);
 }
 
   @Test
 public void perderMenos1000deVida() {
     Saint roxetta = new Saint("Roxetta", new Armadura("Roxa", Categoria.PRATA));
     roxetta.perderVida(-1000);
     assertEquals(1100, roxetta.getVida(), 0.01);
 }
 
}

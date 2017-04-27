

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest
{
   @Test
   public void contraAtaqueFuncionou() throws Exception{
       Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        new VestirArmadura(shiryu).executar();
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new ContraAtaque(shiryu, seiya, dado);
        golpear.executar();
        assertEquals(100.0, seiya.getVida(), 0.01);
        assertEquals(75.0, shiryu.getVida(), 0.01);
   }
   
   @Test
   public void contraAtaqueErradoNaoFuncionouContraBronzeComArmadura() throws Exception{
       Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        new VestirArmadura(shiryu).executar();
        Sorteador dado = new DadoFalso(6);
        Movimento golpear = new ContraAtaque(shiryu, seiya, dado);
        golpear.executar();
        assertEquals(80.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
   }
   
   @Test
   public void contraAtaqueErradoBronzeSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        Sorteador dado = new DadoFalso(5);
        Movimento golpear = new ContraAtaque(shiryu, seiya, dado);
        golpear.executar();
        assertEquals(90.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }
    
     @Test
    public void contraAtaqueErradoSilverComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        new VestirArmadura(misty).executar();
        Sorteador dado = new DadoFalso(6);
        Movimento golpear = new ContraAtaque(misty, seiya, dado);
        golpear.executar();
        assertEquals(70.0, seiya.getVida(), 0.01);
        assertEquals(100.0, misty.getVida(), 0.01);
    }

    @Test
    public void contraAtaqueErradoSilverSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        Sorteador dado = new DadoFalso(5);
        Movimento golpear = new ContraAtaque(misty, seiya, dado);
        golpear.executar();
        assertEquals(90.0, seiya.getVida(), 0.01);
        assertEquals(100.0, misty.getVida(), 0.01);
    }

    @Test
    public void contraAtaqueErradoGoldComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 10));
        new VestirArmadura(aldebaran).executar();
        Sorteador dado = new DadoFalso(6);
        Movimento golpear = new ContraAtaque(aldebaran, seiya, dado);
        golpear.executar();
        assertEquals(60.0, seiya.getVida(), 0.01);
        assertEquals(100.0, aldebaran.getVida(), 0.01);
    }

    @Test
    public void contraAtaqueErradoGoldSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 40));
        Sorteador dado = new DadoFalso(5);
        Movimento golpear = new ContraAtaque(aldebaran, seiya, dado);
        golpear.executar();
        assertEquals(60.0, seiya.getVida(), 0.01);
        assertEquals(100.0, aldebaran.getVida(), 0.01);
    }

    @Test(expected=ArithmeticException.class)
    public void naoGolpearNaoContraAtacar() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Sorteador dado = new DadoFalso(5);
        Movimento golpear = new ContraAtaque(aldebaran, seiya, dado);
        golpear.executar();
    }
    
        @Test
    public void naoGolpearMasContraAtacar() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new ContraAtaque(aldebaran, seiya, dado);
        golpear.executar();
    }
}

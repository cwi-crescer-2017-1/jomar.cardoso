import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AtaqueDuploTest
{
   @Test
   public void ataqueDuploSaintBronzeComArmadura() throws Exception{
       Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        new VestirArmadura(shiryu).executar();
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new AtaqueDuplo(shiryu, seiya, dado);
        golpear.executar();
        assertEquals(60.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }    
    
    @Test
    public void ataqueDuploBronzeSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new AtaqueDuplo(shiryu, seiya, dado);
        golpear.executar();
        assertEquals(80.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void ataqueDuploSilverComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        new VestirArmadura(misty).executar();
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new AtaqueDuplo(misty, seiya, dado);
        golpear.executar();
        assertEquals(40.0, seiya.getVida(), 0.01);
        assertEquals(100.0, misty.getVida(), 0.01);
    }

    @Test
    public void ataqueDuploSilverSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new AtaqueDuplo(misty, seiya, dado);
        golpear.executar();
        assertEquals(80.0, seiya.getVida(), 0.01);
        assertEquals(100.0, misty.getVida(), 0.01);
    }

    @Test
    public void ataqueDuploGoldComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 10));
        new VestirArmadura(aldebaran).executar();
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new AtaqueDuplo(aldebaran, seiya, dado);
        golpear.executar();
        assertEquals(20.0, seiya.getVida(), 0.01);
        assertEquals(100.0, aldebaran.getVida(), 0.01);
    }

    @Test
    public void ataqueDuploGoldSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 40));
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new AtaqueDuplo(aldebaran, seiya, dado);
        golpear.executar();
        assertEquals(20.0, seiya.getVida(), 0.01);
        assertEquals(100.0, aldebaran.getVida(), 0.01);
    }

    @Test(expected=ArithmeticException.class)
    public void naoGolpear() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Sorteador dado = new DadoFalso(2);
        Movimento golpear = new AtaqueDuplo(aldebaran, seiya, dado);
        golpear.executar();
    }
    
     @Test
   public void errarAtaqueDuploSaintBronzeComArmadura() throws Exception{
       Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        new VestirArmadura(shiryu).executar();
        Sorteador dado = new DadoFalso(3);
        Movimento golpear = new AtaqueDuplo(shiryu, seiya, dado);
        golpear.executar();
        assertEquals(80.0, seiya.getVida(), 0.01);
        assertEquals(95.0, shiryu.getVida(), 0.01);
    }
    
    
    @Test
    public void errarGolpearBronzeSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        Sorteador dado = new DadoFalso(3);
        Movimento golpear = new AtaqueDuplo(shiryu, seiya, dado);
        golpear.executar();
        assertEquals(90.0, seiya.getVida(), 0.01);
        assertEquals(95.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void errarGolpearSilverComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        new VestirArmadura(misty).executar();
        Sorteador dado = new DadoFalso(3);
        Movimento golpear = new AtaqueDuplo(misty, seiya, dado);
        golpear.executar();
        assertEquals(70.0, seiya.getVida(), 0.01);
        assertEquals(95.0, misty.getVida(), 0.01);
    }

    @Test
    public void errarGolpearSilverSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));
        Sorteador dado = new DadoFalso(3);
        Movimento golpear = new AtaqueDuplo(misty, seiya, dado);
        golpear.executar();
        assertEquals(90.0, seiya.getVida(), 0.01);
        assertEquals(95.0, misty.getVida(), 0.01);
    }

    @Test
    public void errarGolpearGoldComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 10));
        new VestirArmadura(aldebaran).executar();
        Sorteador dado = new DadoFalso(3);
        Movimento golpear = new AtaqueDuplo(aldebaran, seiya, dado);
        golpear.executar();
        assertEquals(60.0, seiya.getVida(), 0.01);
        assertEquals(95.0, aldebaran.getVida(), 0.01);
    }

    @Test
    public void errarGolpearGoldSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 40));
        Sorteador dado = new DadoFalso(3);
        Movimento golpear = new AtaqueDuplo(aldebaran, seiya, dado);
        golpear.executar();
        assertEquals(60.0, seiya.getVida(), 0.01);
        assertEquals(95.0, aldebaran.getVida(), 0.01);
    }

    @Test(expected=ArithmeticException.class)
    public void errarNaoGolpear() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint aldebaran = new GoldSaint("Aldebaran", "Touro");
        Sorteador dado = new DadoFalso(3);
        Movimento golpear = new AtaqueDuplo(aldebaran, seiya, dado);
        golpear.executar();
    }
}

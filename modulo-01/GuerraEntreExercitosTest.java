import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuerraEntreExercitosTest
{
    @Test
    public void batalhar() throws Exception{
        //arrange
        Golpe soco = new Golpe("Soco", 10);
        Golpe chute = new Golpe("Chute", 20);
        
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        Saint aiolia = new GoldSaint("Aiolia", "Leão");
        defensoresDeAthena.alistar(aiolia);
        aiolia.aprenderGolpe(soco);           
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        defensoresDeAthena.alistar(hyoga);
        hyoga.aprenderGolpe(soco);
        Saint marin = new SilverSaint("Marin", "Águia");
        defensoresDeAthena.alistar(marin);
        marin.aprenderGolpe(soco);
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        defensoresDeAthena.alistar(seiya);
        seiya.aprenderGolpe(soco);
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        defensoresDeAthena.alistar(shura);
        shura.aprenderGolpe(soco);
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        defensoresDeAthena.alistar(shiryu);    
        shiryu.aprenderGolpe(soco);
        
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        Saint misty = new SilverSaint("Misty", "Lagarto");
        impostores.alistar(misty);
        misty.aprenderGolpe(chute);
        Saint mascaraDaMorte = new GoldSaint("Máscara da Morte", "Câncer");
        impostores.alistar(mascaraDaMorte);
        mascaraDaMorte.aprenderGolpe(chute);
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        impostores.alistar(ikki);
        ikki.aprenderGolpe(chute);
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        impostores.alistar(saga);
        saga.aprenderGolpe(chute);
        Saint algol = new SilverSaint("Algol", "Perseu");
        impostores.alistar(algol);
        algol.aprenderGolpe(chute);
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        impostores.alistar(afrodite);        
        afrodite.aprenderGolpe(chute);       
        
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores); 
        
        //act
        ExercitoDeSaints vitorioso = guerra.iniciarBatalha();
        
        //assert
        assertEquals(impostores, vitorioso);
        assertEquals(Status.MORTO, aiolia.getStatus());
        assertEquals(Status.MORTO, hyoga.getStatus());
        assertEquals(Status.MORTO, marin.getStatus());
        assertEquals(Status.MORTO, seiya.getStatus());
        assertEquals(Status.MORTO, shura.getStatus());                
        assertEquals(Status.MORTO, shiryu.getStatus());
        
        assertEquals(Status.VIVO, misty.getStatus());
        assertEquals(Status.VIVO, ikki.getStatus());
        assertEquals(Status.VIVO, saga.getStatus());
        assertEquals(Status.VIVO, algol.getStatus());
        assertEquals(Status.VIVO, mascaraDaMorte.getStatus());                
        assertEquals(Status.VIVO, afrodite.getStatus());
    }
    
    @Test (expected=NullPointerException.class)
    public void exercitosVazios() {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();    
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        
        ExercitoDeSaints vitorioso = guerra.iniciarBatalha();        
    }
    
}

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuerraEntreExercitosTest
{
    public void batalhar() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));    
        
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
        
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        ExercitoDeSaints vitorioso = guerra.iniciarBatalha();
        
        
    }
    
}

import java.util.ArrayList;
public abstract class ExercitoDeSaints 
{
    protected ArrayList<Saint> listaBronze, listaPrata, listaOuro, ordemDeBatalha = new ArrayList<>();
    protected int totalSaints;
    
    public abstract void alistar(Saint saint);
    
    public Saint getProximoSaint() {
        if(this.ordemDeBatalha.size() != 0) {
            Saint saint = this.ordemDeBatalha.get(0);
            this.ordemDeBatalha.remove(0);
            return saint;
        }
        return null;
    }
}

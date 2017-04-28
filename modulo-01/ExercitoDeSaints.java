import java.util.ArrayList;
public abstract class ExercitoDeSaints 
{
    protected ArrayList<Saint> ordemDeBatalha = new ArrayList<>();
    protected int totalSaints;
    
    
        public void alistar(Saint saint){
        Categoria categoria = saint.getArmadura().getCategoria();
        if(categoria.equals(Categoria.BRONZE)) {
            this.ordemDeBatalha.add(0, saint);
        } else if(categoria.equals(Categoria.PRATA)) {
            for(int i = 0 ; i < ordemDeBatalha.size() ; i++) {
                if(ordemDeBatalha.get(i).getArmadura().getCategoria().equals(Categoria.OURO)) {
                    this.ordemDeBatalha.add(i, saint);
                    return;
                }
            }
            this.ordemDeBatalha.add(saint);
        } else {
            this.ordemDeBatalha.add(saint);
        }
    }
    
    public abstract Saint getProximoSaint();
}

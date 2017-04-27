import java.util.ArrayList;
public class ExercitoDeSaints
{
    protected ArrayList<Saint> listaBronze, listaPrata, listaOuro = new ArrayList<>();
    
    public void alistar(Saint saint){
        Categoria categoria = saint.getArmadura().getCategoria();
        if(categoria.equals(Categoria.BRONZE)) {
            this.listaBronze.add(saint);
        } else if(categoria.equals(Categoria.PRATA)) {
            this.listaPrata.add(saint);
        } else {
            this.listaOuro.add(saint);
        }
    }
}

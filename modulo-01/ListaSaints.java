
/**
 Crie uma classe ListaSaints que será responsável por manter um cadastro atualizado dos Saints de Atena,
 para que ela possa se organizar para a Guerra Santa. Nesta classe, implemente as seguintes operações:

adicionar(Saint): adiciona Saint ao final da lista
get(indice): busca o Saint na posição informada por parâmetro

todos(): retorna toda lista de Saint.
remover(Saint): retira o Saint informado da lista
buscarPorNome(String): retorna o primeiro Saint que encontrar com o mesmo nome informado no parâmetro
buscarPorCategoria(Categoria): retorna uma sub-lista de Saint que tenham armadura na categoria informada
buscarPorStatus(Status): retorna uma sub-lista de Saint que tenham o status informado por parâmetro
getSaintMaiorVida(): retorna o Saint com maior vida da lista.
getSaintMenorVida(): retorna o Saint com menor vida da lista.
ordenar(): ordena os Saints de acordo com sua vida (ascendente, do menor ao maior). Importante: 
esta operação APENAS ordena a lista de Saints e não a retorna.
 */

import java.util.ArrayList;
public class ListaSaints
{
   private ArrayList<Saint> listaSaints = new ArrayList<>();
   
   public ListaSaints() {
       
    }
    
   public void adicionar(Saint saint) {
       this.listaSaints.add(saint);
    }
    
    public Saint get(int i) {
        return this.listaSaints.get(i);
    }
    
    
}

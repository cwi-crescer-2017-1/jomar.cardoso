import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints {
    private ArrayList<Saint> saints = new ArrayList<Saint>();
    
    public void adicionar(Saint saint) {
        this.saints.add(saint);
    }
    
    public Saint get(int indice) {
        return this.saints.get(indice);
    }
    
    public ArrayList<Saint> todos() {
        return this.saints;
    }
    
    public void remover(Saint saint) {
        this.saints.remove(saint);
    }
    
    public Saint buscarPorNome(String nome) {
        // C#: foreach (Saint saint in this.saints) { }
        // Python: for saint in saints:
        // JavaScript: for (let saint of saints) { }
        /*for (Saint saint : this.saints) {
            if (saint.getNome().equals(nome)) {
                return saint;
            }
        }
        return null;*/
        return this.saints.stream()
            .filter(s -> s.getNome().equals(nome))
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getArmadura().getCategoria().equals(categoria))
            .collect(Collectors.toList());
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status) {
        return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList());
    }
    
    public Saint getSaintMaiorVida() {
        
        if (saints.isEmpty()) {
            return null;
        }
        
        Saint maiorVida = this.saints.get(0);
        for (int i = 1; i < this.saints.size(); i++) {
            Saint saint = this.saints.get(i);
            boolean encontreiMaior = saint.getVida() > maiorVida.getVida();
            if (encontreiMaior) {
                maiorVida = saint;
            }
        }
        
        return maiorVida;
    }
    
    public Saint getSaintMenorVida() {
        
        if (saints.isEmpty()) {
            return null;
        }
        
        Saint menorVida = this.saints.get(0);
        for (int i = 1; i < this.saints.size(); i++) {
            Saint saint = this.saints.get(i);
            boolean encontreiMenor = saint.getVida() < menorVida.getVida();
            if (encontreiMenor) {
                menorVida = saint;
            }
        }
        
        return menorVida;
    }
    
    public void ordenar() {
        /*
         * BubbleSort
         * Complexidade: O(n^2)
         * 
         * 
         *     [4] [3] [60] [17] [10]
         * i0: [3] [4] [17] [10] [60]
         * i1: [3] [4] [10] [17] [60]
         */
        
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);   
    }   
    
    public void ordenar(TipoOrdenacao tipo) {
        boolean ascendente = tipo.equals(TipoOrdenacao.ASCENDENTE);
        if(ascendente) {
            ordenar();
        } else {
            ordenarDescendente();   
        }   
    }
    
    public void ordenarDescendente() {
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = atual.getVida() < proximo.getVida();
                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
    }
    
    public ListaSaints unir(ListaSaints saints2) {
        ListaSaints uniao = this;
            for(Saint saint: saints2.saints) {
                uniao.saints.add(saint);
            }
        return uniao;
    }
    
    public ListaSaints diff(ListaSaints lista2) {
        ListaSaints diff = new ListaSaints();
        boolean naoRepetido = true;
        for(Saint saint : this.saints) {
            naoRepetido = true;
            for(Saint saint2 : lista2.saints) {
                if(saint.equals(saint2)) {
                    naoRepetido = false;
                }
            }
            if(naoRepetido) {
                diff.saints.add(saint);
            }
        }
        return diff;
    }
    
        public ListaSaints cruzamento(ListaSaints lista2) {
        ListaSaints intersec = new ListaSaints();
        boolean repetido = false;
        for(Saint saint : this.saints) {
            repetido = false;
            for(Saint saint2 : lista2.saints) {
                if(saint.equals(saint2)) {
                    repetido = true;
                }
            }
            if(repetido) {
                intersec.saints.add(saint);
            }
        }
        return intersec;
    }
    
    public String getCSV() {
        String csv = new String();
        for(int i=0 ; i < this.saints.size() ; i++) {
            String nome = this.saints.get(i).getNome();
            csv = csv.concat(nome + ",");
            String vida = Double.toString(this.saints.get(i).getVida());
            csv = csv.concat(vida + ",");
            String nomeConstelacao = this.saints.get(i).getArmadura().getConstelacao().getNome();
            csv = csv.concat(nomeConstelacao + ",");
            String categoriaArmadura = this.saints.get(i).getArmadura().getCategoria().toString();            
            csv = csv.concat(categoriaArmadura + ",");
            String status = this.saints.get(i).getStatus().toString();
            csv = csv.concat(status + ",");
            String genero = this.saints.get(i).getGenero().toString();
            csv = csv.concat(genero + ",");
            String armaduraVestida = Boolean.toString(this.saints.get(i).getArmaduraVestida());
            csv = csv.concat(armaduraVestida + ",");
        }
        return csv;
    }
}
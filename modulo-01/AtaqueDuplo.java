
public class AtaqueDuplo implements Movimento
{
  
    Saint golpeador;
    Saint golpeado;
    
    public AtaqueDuplo(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() {
        Golpear golpear = new Golpear(this.golpeador, this.golpeado);
        Sorteador dado = new DadoD6();
        if(dado.sortear() > 3) {
            
        }
        golpear.executar();
    }
}

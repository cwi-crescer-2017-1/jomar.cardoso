
public class AtaqueDuplo extends Golpear implements Movimento
{  
    public AtaqueDuplo(Saint golpeador, Saint golpeado, Sorteador dado) {
    //public AtaqueDuplo(Saint golpeador, Saint golpeado) {
        super(golpeador, golpeado);        
        int chance = dado.sortear();
        if(chance < 3) {
            this.multiplicadorDano = 2;
        }        
    }  
    
    public void causarDano(double dano) {
        super.causarDano(dano);
        if(this.multiplicadorDano == 1) {
            double autoDano = this.golpeador.getVida() * 0.05;
            this.golpeador.perderVida(autoDano);
        }
        
    }
}

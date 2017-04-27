
public class AtaqueDuplo extends Golpear implements Movimento
{  
    public AtaqueDuplo(Saint golpeador, Saint golpeado) {
        super(golpeador, golpeado);
        this.multiplicadorDano = 2;
    }  
}

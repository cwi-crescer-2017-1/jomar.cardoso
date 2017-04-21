
public class Golpear implements Movimento
{
    private Saint golpeador, golpeado;
    private double fatorDano = 2;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() { 
        this.fatorDano = 2.0;
        boolean armaduraVestida = this.golpeador.getArmaduraVestida();
        if(armaduraVestida) {
            this.fatorDano = this.fatorDano * (1 + this.golpeador.getArmadura().getCategoria().getValor());
        }
        this.golpeado.perderVida(this.fatorDano);
    }
}

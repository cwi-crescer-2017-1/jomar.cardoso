
public class Golpear implements Movimento
{
    private Saint golpeador, golpeado;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar() { 
        int fatorDano = this.golpeador.getProximoGolpe().getFatorDano();
        boolean armaduraVestida = this.golpeador.getArmaduraVestida();
        if(armaduraVestida) {
            fatorDano = fatorDano * (1 + this.golpeador.getArmadura().getCategoria().getValor());
        }
        this.golpeado.perderVida(fatorDano);
    }
}

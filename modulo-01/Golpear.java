public class Golpear implements Movimento {
    
    protected Saint golpeador, golpeado;
    protected int multiplicadorDano;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;        
        this.multiplicadorDano = 1;
    }
    
    public void executar() {
        Golpe golpe = this.golpeador.getProximoGolpe();  
        double dano = calcularDano(golpe);
        this.golpeado.perderVida(dano);
    }
    
    public double calcularDano(Golpe golpe) {
        double danoCalculado = golpe.getFatorDano() * this.multiplicadorDano;       
        if (golpeador.getArmaduraVestida()) {
            danoCalculado *= 1 + this.golpeador.getArmadura().getCategoria().getValor();
        }
         return danoCalculado;
    }
    
    public boolean equals(Object outro) {
        Golpear outroGolpear = (Golpear)outro;
        return this.golpeador.equals(outroGolpear.golpeador)
            && this.golpeado.equals(outroGolpear.golpeado);
    }
}

public class ContraAtaque extends Golpear implements Movimento
{
   public ContraAtaque(Saint golpeador, Saint golpeado, Sorteador dado) {
      super(golpeador, golpeado);        
      int chance = dado.sortear();
      if(chance < 5) {
          this.multiplicadorDano = 0;
      }       
   }
   
   public void executar() {
       if (this.multiplicadorDano == 0) {
           double dano = golpeado.getVida() * 0.25;
           this.golpeador.perderVida(dano);
        } else {
            super.executar();
        }
    }
   
}

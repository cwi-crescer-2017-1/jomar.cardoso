public class Batalha {

    private Saint saint1, saint2;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar() {
       int valor1 = this.saint1.getArmadura().getCategoria().getValor();
       int valor2 = this.saint2.getArmadura().getCategoria().getValor();
       boolean vivo = true;
       Saint atacante, atacado, aux;
       if (valor1 >= valor2) {
           atacante = this.saint1;
           atacado = this.saint2;  
       } else {
           atacante = this.saint2;
           atacado = this.saint1;
       }
       
       do {
           Golpear golpe = new Golpear(atacante, atacado);
           golpe.executar();
           vivo = Status.VIVO.equals(atacado.getStatus());
           aux = atacante;
           atacante = atacado;
           atacado = aux;
       } while(vivo);

    }
}

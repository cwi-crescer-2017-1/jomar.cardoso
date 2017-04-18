public class Batalha {
    
    private Saint saint1, saint2;
    private double dano = 10;   
    
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    
    public void iniciar() {
        int valorArmadura1 = this.saint1.getArmadura().getCategoria().getValor();
        int valorArmadura2 = this.saint2.getArmadura().getCategoria().getValor();
        if(valorArmadura1 >= valorArmadura2) {
            saint2.perderVida(this.dano);
        } else {
            saint1.perderVida(this.dano);
        }
    }
}

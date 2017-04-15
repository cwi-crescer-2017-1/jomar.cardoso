public class Batalha {
    
    public void iniciar(Saint saint1, Saint saint2) {
        int valorArmadura1 = saint1.getArmadura().getCategoria().getValor();
        int valorArmadura2 = saint2.getArmadura().getCategoria().getValor();
        if(valorArmadura1 >= valorArmadura2) {
            saint2.perderVida(10);
        } else {
            saint1.perderVida(10);
        }
    }
}

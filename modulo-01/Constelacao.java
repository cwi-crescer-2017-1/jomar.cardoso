public class Constelacao
{
    private String nome;
    //private Golpe[] golpes;
    private Golpe golpes;
    
    public Constelacao(String nome){
        this.nome = nome;
        //this.golpes = new Golpe[10];
    }
    
    public void adicionarGolpe(Golpe golpe) {
        //this.golpes[0] = golpe;
        this.golpes = golpe;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    //public Golpe[] getGolpes() {
    public Golpe getGolpes() {
        return this.golpes;
    }
}

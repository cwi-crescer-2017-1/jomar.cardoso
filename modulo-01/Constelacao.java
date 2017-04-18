public class Constelacao
{
    private String nome;
    private Golpe[] golpes;
    
    public Constelacao(String nome){
        this.nome = nome;
        this.golpes = new Golpe[10];
    }
    
    public void adicionarGolpe(Golpe golpe) {
        int i = 0;
        while(this.golpes[i] != null) {             
            i++;
        }   
        this.golpes[i] = golpe;    
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Golpe[] getGolpes() {
        return this.golpes;
    }
}

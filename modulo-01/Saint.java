public class Saint {
    private String nome;
    public Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100;
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    public double perderVida(double vidaPerdida) {
        this.vida = vida - vidaPerdida;
        return vida;
    }
    
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }
    
    public Genero getGenero(){
        return this.genero;
    }
    
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Armadura getArmadura() {
        return this.armadura;
    }
    
    public double getVida() {
        return this.vida;
    }
    
   
}
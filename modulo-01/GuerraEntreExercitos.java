public class GuerraEntreExercitos
{
    private ExercitoDeSaints exercito1, exercito2;
    public GuerraEntreExercitos(ExercitoDeSaints exercito1, ExercitoDeSaints exercito2) {
        this.exercito1 = exercito1;
        this.exercito2 = exercito2;
    }
    
    public ExercitoDeSaints iniciarBatalha() {
        int vitoriasExercito1 = 0;
        int vitoriasExercito2 = 0;
        Saint saint1 = this.exercito1.getProximoSaint();
        Saint saint2 = this.exercito2.getProximoSaint();
        do {
            Batalha batalha = new Batalha(saint1, saint2);
            batalha.iniciar();
            if(saint1.getStatus() == Status.MORTO) {
                vitoriasExercito2++;
            } else {
                vitoriasExercito1++;
            }
            saint1 = this.exercito1.getProximoSaint();
            saint2 = this.exercito2.getProximoSaint();
        } while(saint1 != null || saint2 !=null);
        if(vitoriasExercito1 > vitoriasExercito2) {
            return this.exercito1;
        } else {
            return this.exercito2;
        }
    }
}


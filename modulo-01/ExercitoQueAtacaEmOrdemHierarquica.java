public class ExercitoQueAtacaEmOrdemHierarquica extends ExercitoDeSaints
{   
    
    public Saint getProximoSaint() {
        if(this.ordemDeBatalha.size() != 0) {
            Saint saint = this.ordemDeBatalha.get(0);
            this.ordemDeBatalha.remove(0);
            return saint;
        }
        return null;
    }
}

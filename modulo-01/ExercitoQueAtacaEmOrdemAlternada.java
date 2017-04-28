public class ExercitoQueAtacaEmOrdemAlternada extends ExercitoDeSaints
{
    protected int categoriaDesejada = 0;
    
    public Saint getProximoSaint() {
        if(this.ordemDeBatalha.size() != 0) {
            categoriaDesejada = (categoriaDesejada + 1) % 3;
            for(int i=0; i<3; i++) {
                for(int j=0; j < ordemDeBatalha.size(); j++) {
                    if(categoriaDesejada == this.ordemDeBatalha.get(j).getArmadura().getCategoria().getValor()) {
                        categoriaDesejada = (categoriaDesejada + 1) % 3;
                        Saint saint = ordemDeBatalha.get(j);
                        ordemDeBatalha.remove(j);
                        return saint;
                    }
                }
                categoriaDesejada = (categoriaDesejada + 1) % 3;
            }        
        }
        return null;
   }
}
//testar
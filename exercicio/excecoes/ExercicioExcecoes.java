package exercicio.excecoes;

public class ExercicioExcecoes {
    private double temperatura = 0.0;

    public double getTemperatura() {
        return temperatura;
    }

    public void aumentaTemperatura(double tempMais){
        try {
            if(tempMais < 0){
                throw new IllegalArgumentException("Valor inválido");
            }
            this.temperatura += tempMais;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro em aumentaTemperatura: " + e.getMessage());
        }
   }

   public void diminuiTemperatura(double tempMenos){
        try {
            if(tempMenos < 0){
                throw new IllegalArgumentException("Valor inválido");
            }
                this.temperatura -= tempMenos;
        
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valor inválido");
        }
    }
}

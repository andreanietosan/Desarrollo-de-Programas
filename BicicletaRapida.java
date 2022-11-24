public class BicicletaRapida extends BicicletaNormal {
    private double velocidadExtra;

    public BicicletaRapida(String nombreBicicleta, Peso peso) {
        super(nombreBicicleta, peso);
        this.velocidadExtra = 0.0;
    }

    public double calcularVelocidad(Ciclista ciclista, Etapa etapa) {
        double resultado = super.calcularVelocidad(ciclista, etapa);
        double extra = Math.round(resultado + velocidadExtra);
        return extra;
    }



}



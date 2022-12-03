public class BicicletaRapida extends BicicletaNormal {
    private double velocidadExtra;

    public BicicletaRapida(String nombreBicicleta, Peso peso, double velocidadExtra) {
        super(nombreBicicleta, peso);
        this.velocidadExtra = velocidadExtra;
    }

    @Override
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa) {
        double resultado = super.calcularVelocidad(ciclista, etapa);
        double extra = resultado + velocidadExtra;
        return (double) Math.round(extra * 100) / 100;
    }

    public String toString() {
        return super.toString() + "<velocidad extra: " + velocidadExtra + ">";
    }

}



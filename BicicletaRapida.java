public class BicicletaRapida extends BicicletaNormal {
    private double velocidadExtra;

    public BicicletaRapida(String nombreBicicleta, Peso peso, double velocidadExtra) {
        super(nombreBicicleta, peso);
        this.velocidadExtra = velocidadExtra;
    }

    public double calcularVelocidad(Ciclista ciclista, Etapa etapa) {
        double resultado = super.calcularVelocidad(ciclista, etapa);
        double extra = Math.round(resultado + velocidadExtra);
        return extra;
    }

    public String getTipo() {
        return "BicicletaRapida";
    }

    public String toString() {
        return super.toString() + "<velocidad extra: " + velocidadExtra + ">";
    }

}



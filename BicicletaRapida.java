/**
 * BicicletaRapida es una subclase de Bicicleta el cuál es una bicicleta normal pero tiene un extra que se diferencia del resto de tipos de bicicletas
 * y es que dispone de una velocidad extra
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class BicicletaRapida extends BicicletaNormal {
    private double velocidadExtra;

    /**
     * Constructor por parámetros de la clase BicicletaRapida
     */
    public BicicletaRapida(String nombreBicicleta, Peso peso, double velocidadExtra) {
        super(nombreBicicleta, peso);
        this.velocidadExtra = velocidadExtra;
    }

    /**
     * Calcula la velocidad que es usada por un ciclista en particular en una etapa en concreto, teniendo en cuenta
     * para este tipo de ciclista su velocidad extra
     *
     * @param ciclista Ciclista del que se usa su habilidad
     * @param etapa    Etapa de la que se usa la dificultad
     * @return  La velocidad calculada
     */
    @Override
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa) {
        double resultado = super.calcularVelocidad(ciclista, etapa);
        double extra = resultado + velocidadExtra;
        return (double) Math.round(extra * 100) / 100;
    }

    /**
     * Muestra en una cadena los atributos de la bicibletaRapida
     *
     * @return Un string con los atributos y características principales de la bicibleta
     */
    public String toString() {
        return super.toString() + "<velocidad extra: " + velocidadExtra + ">";
    }

}



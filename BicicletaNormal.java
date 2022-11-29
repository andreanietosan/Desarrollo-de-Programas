/**
 * En la clase Bicicleta se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class BicicletaNormal implements Bicicleta {
    private String nombreBicicleta;
    private Peso peso;

    /**
     * Constructor para objetos de la clase Bicicleta
     *
     * @param nombreBicicleta Nombre que tiene cada bicicleta
     * @param peso            Peso que corresponde a cada bicicleta
     */
    public BicicletaNormal(String nombreBicicleta, Peso peso) {
        this.nombreBicicleta = nombreBicicleta;
        this.peso = peso;
    }

    public String getNombreBicicleta() {
        return nombreBicicleta;
    }

    public void setNombreBicicleta(String nombreBicicleta) {
        this.nombreBicicleta = nombreBicicleta;
    }

    public Peso getPeso() {
        return peso;
    }

    public void setPeso(Peso peso) {
        this.peso = peso;
    }

    public double getValorPeso() {
        return getPeso().getValor();
    }

    public String getTipo() {
        return "BicicletaNormal";
    }

    public double calcularVelocidad(Ciclista ciclista, Etapa etapa) {
        return (double) Math.round((ciclista.getValorHabilidad() * 100) / (peso.getValor() * etapa.getValorDificultad()) * 100.0) / 100.0;
    }

    public double calcularTiempoNecesario(Etapa etapa, Ciclista ciclista) {
        return (double) Math.round((etapa.getValorDistancia() / this.calcularVelocidad(ciclista, etapa) * 60) * 100) / 100;
    }

    /**
     * Muestra en una cadena los atributos de la bicibleta
     *
     * @return Un string con los atributos y características principales de la bicibleta
     */
    public String toString() {
        return "<" + getTipo() + ">: <peso:" + getPeso() + ")>";
    }


}

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

    public double calcularVelocidad(Ciclista ciclista, Etapa etapa) {
        return (double) Math.round((ciclista.getValorHabilidad() * 100) / (peso.getValor() * etapa.getValorDificultad()) * 100) / 100;
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
        return "<" + getClass().getName() + ": " + getNombreBicicleta() + "> <peso:" + getPeso() + ")>";
    }

    /**
     * Redefinicion del metodo equals() en la clase BicicletaNormal
     *
     * @return true si las 2 bicicletaNormal comparadas son iguales, false en otro caso
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof BicicletaNormal))
            return false;
        BicicletaNormal other = (BicicletaNormal) obj;
        return getNombreBicicleta().equals(other.getNombreBicicleta());
    }

    /**
     * Devuelve un valor entero que representa de forma inequívoca a un objeto de la clase BicicletaNormal
     *
     * @return un valor entero
     */
    @Override
    public int hashCode() {
        int resultado = 7;
        resultado = 3 * resultado + getNombreBicicleta().hashCode();
        return resultado;
    }


}

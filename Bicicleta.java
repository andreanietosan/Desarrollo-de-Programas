/**
 * En la clase Bicicleta se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Bicicleta {
    private String nombreBicicleta;
    private Peso peso;

    /**
     * Constructor para objetos de la clase Bicicleta
     *
     * @param nombreBicicleta Nombre que tiene cada bicicleta
     * @param peso            Peso que corresponde a cada bicicleta
     */
    public Bicicleta(String nombreBicicleta, Peso peso) {
        this.nombreBicicleta = nombreBicicleta;
        this.peso = peso;
    }

    /**
     * Devuelve el atributo nombre de la clase Bicicleta
     *
     * @return El atributo nombre de la Bicicleta
     */
    public String getNombreBicicleta() {
        return nombreBicicleta;
    }

    /**
     * Asigna un nombre a la Bicicleta
     *
     * @param nombreBicicleta Nombre que se le va asignar a la Bicicleta
     */
    public void setNombreBicicleta(String nombreBicicleta) {
        this.nombreBicicleta = nombreBicicleta;
    }

    /**
     * Devuelve el atributo peso de la clase Bicicleta
     *
     * @return El atributo peso de la Bicicleta
     */
    public Peso getPeso() {
        return peso;
    }

    /**
     * Asigna un peso a la Bicicleta
     *
     * @param peso Peso que se le va asignar a la Bicicleta
     */
    public void setPeso(Peso peso) {
        this.peso = peso;
    }

    public double getValorPeso() {
        return getPeso().getValor();
    }

    /**
     * Calcula la velocidad que es usada por un ciclista en particular en una etapa en concreto
     *
     * @param ciclista Ciclista del que se usa su habilidad
     * @param etapa    Etapa de la que se usa la dificultad
     * @return La velocidad calculada
     */
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa) {
        return (double) Math.round((ciclista.getHabilidad() * 100) / (peso.getValor() * etapa.getValorDificultad()) * 100.0) / 100.0;
    }

    /**
     * Calcula el tiempo necesario (en minutos) para terminar la etapa cuando es usada por un ciclista en particular en una etapa en concreto
     *
     * @param etapa    Etapa de la que se usa su distancia
     * @param ciclista Ciclista que se usa para calcular la velocidad (anteriormente calculada)
     * @return El tiempo necesario para terminar una etapa
     */
    public double calcularTiempoNecesario(Etapa etapa, Ciclista ciclista) {
        return (double) Math.round((etapa.getValorDistancia() / this.calcularVelocidad(ciclista, etapa) * 60) * 100) / 100;
    }

    /**
     * Muestra en una cadena los atributos de la bicibleta
     *
     * @return Un string con los atributos y características principales de la bicibleta
     */
    public String toString() {
        return "<bicicleta:" + getNombreBicicleta() + "> <peso:" + getPeso() + ")>";
    }


}

/**
 * En la clase Etapa se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Etapa implements EtapaInterface{

    private String nombreEtapa;
    private Dificultad dificultad;
    private Distancia distancia;

    /**
     * Constructor para objetos de la clase Etapa
     *
     * @param nombreEtapa Nombre de cada etapa
     * @param dificultad  Dificultad que corresponde a cada etapa
     * @param distancia   Distancia que tiene cada etapa
     */
    public Etapa(String nombreEtapa, Dificultad dificultad, Distancia distancia) {
        this.nombreEtapa = nombreEtapa;
        this.dificultad = dificultad;
        this.distancia = distancia;
    }

    /**
     * Devuelve el atributo nombre de la clase Etapa
     *
     * @return El atributo nombre de la Etapa
     */
    public String getNombreEtapa() {
        return nombreEtapa;
    }

    /**
     * Asigna un nombre a la Etapa
     *
     * @param nombreEtapa Nombre que se le va asignar a la Etapa
     */
    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    /**
     * Devuelve el atributo dificultad de la clase Etapa
     *
     * @return El atributo dificultad de la Etapa
     */
    public Dificultad getDificultad() {
        return dificultad;
    }

    /**
     * Asigna una dificultad a la Etapa
     *
     * @param dificultad Dificultad que se le va asignar a la Etapa
     */
    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * Devuelve el atributo distancia de la clase Etapa
     *
     * @return El atributo distancia de la Etapa
     */
    public Distancia getDistancia() {
        return distancia;
    }

    /**
     * Asigna una distancia a la Etapa
     *
     * @param distancia Distancia que se le va asignar a la Etapa
     */
    public void setDistancia(Distancia distancia) {
        this.distancia = distancia;
    }


    public double getValorDificultad() {
        return getDificultad().getValor();
    }

    public double getValorDistancia() {
        return getDistancia().getValor();
    }

    /**
     * Muestra en una cadena los atributos de la etapa
     *
     * @return Un string con los atributos y características principales de la etapa
     */
    public String toString() {
        return "<etapa:" + getNombreEtapa() + "> <dificultad:" + getDificultad() + "> <distancia:" + getDistancia() + ")>";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Etapa))
            return false;
        Etapa other = (Etapa) obj;
        return getNombreEtapa().equals(other.getNombreEtapa());
    }
}

/**
 * En la clase Etapa se encuentra toda la información de esta
 * 
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Etapa {

    private String nombreEtapa;
    private double dificultad;
    private int distancia;

    /**
     * Constructor para objetos de la clase Etapa
     */
    public Etapa(String nombreEtapa, double dificultad, int distancia) {
        this.nombreEtapa = nombreEtapa;
        this.dificultad = dificultad;
        this.distancia = distancia;
    }

    /**
     * Devuelve el atributo nombre de la clase Etapa
     * @return El atributo nombre de la Etapa
     */
    public String getNombreEtapa() {
        return nombreEtapa;
    }

    /**
     * Asigna un nombre a la Etapa
     * @param nombreEtapa    Nombre que se le va asignar a la Etapa
     */
    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    /**
     * Devuelve el atributo dificultad de la clase Etapa
     * @return El atributo dificultad de la Etapa
     */
    public double getDificultad() {
        return dificultad;
    }

    /**
     * Asigna una dificultad a la Etapa
     * @param dificultad    Dificultad que se le va asignar a la Etapa
     */
    public void setDificultad(double dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * Devuelve el atributo distancia de la clase Etapa
     * @return El atributo distancia de la Etapa
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * Asigna una distancia a la Etapa
     * @param distancia     Distancia que se le va asignar a la Etapa
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * Muestra en una cadena los atributos de la etapa
     * @return Un string con los atributos y características principales de la etapa
     */
    public String toString() {
        return "<etapa:" + getNombreEtapa() + "> <dificultad:" + getDificultad() + "> <distancia:" + getDistancia() + ")>";
    }

}

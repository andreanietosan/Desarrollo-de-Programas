/**
 * En la clase Resultado se encuentra toda la información de esta relacionada con los ciclistas
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Resultado {
    private Etapa etapa;
    private double tiempo;
    private boolean etapaTerminada;


    /**
     * Constructor para objetos de la clase Resultado
     * @param etapa     Etapa en la que participa
     * @param tiempo    Tiempo necesario en cada etapa
     * @param etapaTerminada    Etapas que ha terminado
     */
    public Resultado(Etapa etapa, double tiempo, boolean etapaTerminada) {
        this.etapa = etapa;
        this.tiempo = tiempo;
        this.etapaTerminada = etapaTerminada;
    }

    /**
     * Devuelve el atributo etapa de la clase Resultado
     * @return  El atributo etapa de Resultado
     */
    public Etapa getEtapa() {
        return etapa;
    }

    /**
     * Asigna una etapa a Resultado
     * @param etapa     Etapa que se le va asignar a Resultado
     */
    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    /**
     * Devuelve el atributo tiempo de la clase Resultado
     * @return  El atributo tiempo de Resultado
     */
    public double getTiempo() {
        return tiempo;
    }

    /**
     * Asigna una tiempo a Resultado
     * @param tiempo    Tiempo que se le va asignar a Resultado
     */
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Devuelve si una etapa ha terminado o no de la clase Resultado
     * @return  Terminada o no
     */
    public boolean isEtapaTerminada() {
        return etapaTerminada;
    }

    /**
     * Asigna una etapa terminada a Resultado
     * @param etapaTerminada    Etapa que ha terminado
     */
    public void setEtapaTerminada(boolean etapaTerminada) {
        this.etapaTerminada = etapaTerminada;
    }
}

/**
 * En la clase EtapaInterface se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Etapa implements EtapaInterface {

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

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Distancia getDistancia() {
        return distancia;
    }

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

    /**
     * Redefinicion del metodo equals() en la clase Etapa
     *
     * @return true si las 2 etapas comparadas son iguales, false en otro caso
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Etapa))
            return false;
        Etapa other = (Etapa) obj;
        return getNombreEtapa().equals(other.getNombreEtapa());
    }

    /**
     * Devuelve un valor entero que representa de forma inequívoca a un objeto de la clase Etapa
     *
     * @return un valor entero
     */
    @Override
    public int hashCode() {
        int resultado = 7;
        resultado = 3 * resultado + getNombreEtapa().hashCode();
        return resultado;
    }
}

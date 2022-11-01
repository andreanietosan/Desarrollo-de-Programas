import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * En la clase Ciclista se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Equipo {
    private String nombreEquipo;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicicletas;
    private Comparator compCiclistas;
    private Comparator compBicicletas;

    /**
     * Constructor para objetos de la clase Equipo
     *
     * @param nombreEquipo   Nombre del equipo
     * @param compCiclistas  Comparadores de los ciclistas de cada equipo
     * @param compBicicletas Comparadores de las bicicletas de cada equipo
     */
    public Equipo(String nombreEquipo, Comparator compCiclistas, Comparator compBicicletas) {
        this.nombreEquipo = nombreEquipo;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicicletas = new ArrayList<Bicicleta>();
        this.compCiclistas = compCiclistas;
        this.compBicicletas = compBicicletas;
    }

    /**
     * Devuelve el atributo nombre de la clase Equipo
     *
     * @return El atributo nombre del Equipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Asigna un nombre al Equipo
     *
     * @param nombreEquipo Nombre que se le va asignar al Equipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Devuelve la lista de ciclistas de cada equipo
     *
     * @return La lista de Ciclistas
     */
    public ArrayList<Ciclista> getCiclistas() {
        return ciclistas;
    }

    /**
     * Asigna la lista de ciclistas de cada equipo
     *
     * @param ciclistas Lista de ciclistas que tiene asignada cada Equipo
     */
    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    /**
     * Devuelve la lista de ciclistas abandonados de cada equipo
     *
     * @return La lista de ciclistas abandonados
     */
    public ArrayList<Ciclista> getCiclistasAbandonados() {
        return ciclistasAbandonados;
    }

    /**
     * Asigna la lista de ciclistas abandonados de cada equipo
     *
     * @param ciclistasAbandonados Lista de ciclistas abandonados que tiene asignado cada Equipo
     */
    public void setCiclistasAbandonados(ArrayList<Ciclista> ciclistasAbandonados) {
        this.ciclistasAbandonados = ciclistasAbandonados;
    }

    /**
     * Devuelve la lista de bicicletas de cada equipo
     *
     * @return La lista de bicicletas
     */
    public ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    /**
     * Asigna la lista de bicicletas de cada equipo
     *
     * @param bicicletas Lista de bicicletas que tiene asignado cada Equipo
     */
    public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }

    /**
     * Asigna una bicicleta a cada ciclista de cada equipo
     *
     * @param ciclista Ciclista al que se le va asignar la bicicleta
     */
    public void asignarBicicleta(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    /**
     * Devuelve el tiempo total acumulado de cada ciclista en una etapa
     *
     * @return El tiempo total
     */
    public double getTiempoTotal() {
        double tiempo = 0;
        for (Ciclista c : ciclistas)
            tiempo += c.getTiempoTerminadas();
        return tiempo;
    }

    /**
     * Ordena a los ciclistas de cada equipo
     */
    public void ordenarCiclistas() {
        Collections.sort(ciclistas, this.compCiclistas);
    }

    /**
     * Ordena a los ciclistas de cada equipo
     */
    public void ordenarBicicletas() {
        Collections.sort(bicicletas, this.compBicicletas);
    }

    /**
     * Añade la bicicleta de cada equipo
     *
     * @param b Bicicleta añadida a cada equipo
     */
    public void anadirBicicleta(Bicicleta b) {
        bicicletas.add(b);
    }

    /**
     * Añade al ciclista a cada equipo
     *
     * @param c Ciclista añadido a cada equipo
     */
    public void anadirCiclista(Ciclista c) {
        ciclistas.add(c);
    }

    /**
     * Añade al ciclista abandonado de cada equipo
     *
     * @param c Ciclista abandonado añadido a cada equipo
     */
    public void anadirCiclistaAbandonado(Ciclista c) {
        ciclistasAbandonados.add(c);
    }

    /**
     * Calcula el tiempo medio de cada equipo al finalizar la competición
     *
     * @return Tiempo medio de cada equipo
     */
    public double calcularMediaEquipo() {
        double media = 0;
        int numCiclista = 0;
        for (Ciclista c : getCiclistas())
            if (!c.comprobarAbandono()) {
                media += c.getTiempoTerminadas();
                numCiclista += 1;
            }
        media /= numCiclista;
        return (double) Math.round(media * 100) / 100;
    }

    /**
     * Muestra en una cadena los atributos del equipo
     *
     * @return Un string con los atributos y características principales del equipo
     */
    public String toString() {
        return "%%% " + getNombreEquipo() + " %%% Media Minutos de Ciclistas sin abandonar " + getTiempoTotal() + " %%%";
    }
}

import java.util.ArrayList;
import java.util.Collections;

public interface EquipoInterface {

    /**
     * Devuelve el atributo nombre de la clase Equipo
     *
     * @return El atributo nombre del Equipo
     */
    public String getNombreEquipo();

    /**
     * Asigna un nombre al Equipo
     *
     * @param nombreEquipo Nombre que se le va asignar al Equipo
     */
    public void setNombreEquipo(String nombreEquipo);

    /**
     * Devuelve la lista de ciclistas de cada equipo
     *
     * @return La lista de Ciclistas
     */
    public ArrayList<Ciclista> getCiclistas();

    /**
     * Asigna la lista de ciclistas de cada equipo
     *
     * @param ciclistas Lista de ciclistas que tiene asignada cada Equipo
     */
    public void setCiclistas(ArrayList<Ciclista> ciclistas);

    /**
     * Devuelve la lista de ciclistas abandonados de cada equipo
     *
     * @return La lista de ciclistas abandonados
     */
    public ArrayList<Ciclista> getCiclistasAbandonados();

    /**
     * Asigna la lista de ciclistas abandonados de cada equipo
     *
     * @param ciclistasAbandonados Lista de ciclistas abandonados que tiene asignado cada Equipo
     */
    public void setCiclistasAbandonados(ArrayList<Ciclista> ciclistasAbandonados);

    /**
     * Devuelve la lista de bicicletas de cada equipo
     *
     * @return La lista de bicicletas
     */
    public ArrayList<Bicicleta> getBicicletas();

    /**
     * Asigna la lista de bicicletas de cada equipo
     *
     * @param bicicletas Lista de bicicletas que tiene asignado cada Equipo
     */
    public void setBicicletas(ArrayList<Bicicleta> bicicletas);

    /**
     * Asigna una bicicleta a cada ciclista de cada equipo
     *
     * @param ciclista Ciclista al que se le va asignar la bicicleta
     */
    public void asignarBicicleta(Ciclista ciclista);

    /**
     * Devuelve el tiempo total acumulado de cada ciclista en una etapa
     *
     * @return El tiempo total
     */
    public double getTiempoTotal();

    /**
     * Ordena a los ciclistas de cada equipo
     */
    public void ordenarCiclistas();


    /**
     * Ordena a los ciclistas de cada equipo
     */
    public void ordenarBicicletas();

    /**
     * Añade la bicicleta de cada equipo
     *
     * @param b Bicicleta añadida a cada equipo
     */
    public void anadirBicicleta(Bicicleta b);

    /**
     * Añade al ciclista a cada equipo
     *
     * @param c Ciclista añadido a cada equipo
     */
    public void anadirCiclista(Ciclista c);

    /**
     * Añade al ciclista abandonado de cada equipo
     *
     * @param c Ciclista abandonado añadido a cada equipo
     */
    public void anadirCiclistaAbandonado(Ciclista c);

    /**
     * Calcula el tiempo medio de cada equipo al finalizar la competición
     *
     * @return Tiempo medio de cada equipo
     */
    public double calcularMediaEquipo();
}

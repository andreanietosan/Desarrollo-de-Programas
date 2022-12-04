import java.util.Comparator;

/**
 * Realiza una comparación entre dos equipos a través de sus nombres
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */public class ComparadorNombreEquipo implements Comparator<Equipo> {
    public int compare(Equipo e1, Equipo e2) {

        return (e1.getNombreEquipo().compareTo(e2.getNombreEquipo()));
    }
}

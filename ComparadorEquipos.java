import java.util.Comparator;

/**
 * Realiza una comparación entre dos equipos a través del tiempo medio, el nombre del equipo y tiempo total de cada ciclista
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorEquipos implements Comparator<Equipo> {
    public int compare(Equipo e1, Equipo e2) {
        if (e1.calcularMediaEquipo() == e2.calcularMediaEquipo())
            return new ComparadorTiempoTotal().compare(e1, e2);
        else if (e1.calcularMediaEquipo() > e2.calcularMediaEquipo())
            return 1;
        else
            return -1;
    }
}

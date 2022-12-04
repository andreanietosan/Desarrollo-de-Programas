import java.util.Comparator;

/**
 * Realiza una comparación entre dos equipos a través del  tiempo total acumulado de cada ciclista en una etapa
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorTiempoTotal implements Comparator<Equipo> {
    public int compare(Equipo e1, Equipo e2) {
        if (e1.getTiempoTotal() == e2.getTiempoTotal())
            return new ComparadorNombreEquipo().compare(e1, e2);
        else if (e1.getTiempoTotal() > e2.getTiempoTotal())
            return 1;
        else
            return -1;


    }
}

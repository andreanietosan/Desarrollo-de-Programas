import java.util.Comparator;

/**
 * Realiza una comparación entre dos etapas a través de sus nombres
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorNombreEtapa implements Comparator<Etapa> {
    public int compare(Etapa e1, Etapa e2) {
        return (e1.getNombreEtapa().compareTo(e2.getNombreEtapa()));
    }
}

import java.util.Comparator;

/**
 * Realiza una comparación entre dos ciclsitas a través de sus nombres
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorNombreCiclista implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {

        return (c2.getNombreCiclista().compareTo(c1.getNombreCiclista()));
    }
}

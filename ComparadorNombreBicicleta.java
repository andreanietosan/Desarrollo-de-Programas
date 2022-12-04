import java.util.Comparator;

/**
 * Realiza una comparación entre dos bicicletas a través de sus nombres
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorNombreBicicleta implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        return (b1.getNombreBicicleta().compareTo(b2.getNombreBicicleta()));
    }
}

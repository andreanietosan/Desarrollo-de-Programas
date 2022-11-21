import java.util.Comparator;

/**
 * Realiza una comparación entre dos ciclistas a través de su energía
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparatorEnergia implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getEnergia() == c2.getEnergia())
            return new ComparadorNombreCiclista().compare(c1, c2);
        else if (c1.getEnergia() > c2.getEnergia())
            return 1;
        else
            return -1;
    }
}

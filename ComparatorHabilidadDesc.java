import java.util.Comparator;

/**
 * Realiza una comparación entre dos ciclistas a través de su habilidad descendentemente
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparatorHabilidadDesc implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getHabilidad() == c2.getHabilidad())
            return new ComparadorNombreCiclista().compare(c1, c2);
        else if (c1.getHabilidad() < c2.getHabilidad())
            return 1;
        else
            return -1;
    }
}

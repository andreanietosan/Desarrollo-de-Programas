import java.util.Comparator;

/**
 * Realiza una comparación entre dos ciclistas a través del tiempo que tardan en una etapa
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorTiempoEtapa implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTiempoEtapa() == c2.getTiempoEtapa())
            return new ComparadorNombreCiclista().compare(c1, c2);
        else if (c1.getTiempoEtapa() > c2.getTiempoEtapa())
            return 1;
        else
            return -1;
    }
}


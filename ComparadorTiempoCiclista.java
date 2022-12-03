import java.util.Comparator;

/**
 * Realiza una comparación entre dos ciclistas a través del tiempo que tardan en terminar una etapa
 * Comparación ascendente
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorTiempoCiclista implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTiempoTerminadas() == c2.getTiempoTerminadas())
            return new ComparadorNombreCiclista().compare(c1, c2);
        else if (c1.getTiempoTerminadas() > c2.getTiempoTerminadas())
            return 1;
        else
            return -1;
    }
}


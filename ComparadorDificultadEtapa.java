import java.util.Comparator;

/**
 * Realiza una comparación entre dos etapas a través de la dificultad y la distancia
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparadorDificultadEtapa implements Comparator<Etapa> {
    public int compare(Etapa e1, Etapa e2) {
        if (e1.getDificultad() == e2.getDificultad())
            return new ComparadorDistanciaEtapa().compare(e1, e2);
        else if (e1.getDificultad() > e2.getDificultad())
            return 1;
        else
            return -1;
    }
}

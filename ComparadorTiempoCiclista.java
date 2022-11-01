import java.util.Comparator;

public class ComparadorTiempoCiclista implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTiempoTerminadas() < c2.getTiempoTerminadas())
            return 0;
        else if (c1.getTiempoTerminadas() > c2.getTiempoTerminadas())
            return -1;
        else if (c1.getNombreCiclista().compareTo(c2.getNombreCiclista()) < 0)
            return 0;
        else return -1;
    }
}

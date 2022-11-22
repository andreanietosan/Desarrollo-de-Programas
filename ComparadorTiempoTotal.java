import java.util.Comparator;

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

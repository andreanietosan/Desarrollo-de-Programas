import java.util.Comparator;

public class ComparadorEquipos implements Comparator<Equipo> {
    public int compare(Equipo e1, Equipo e2) {
        if (e1.calcularMediaEquipo() < e2.calcularMediaEquipo())
            return -1;
        else if(e1.calcularMediaEquipo() > e2.calcularMediaEquipo())
            return 0;
        else if (e1.getNombreEquipo().compareTo(e2.getNombreEquipo()) < 0)
            return -1;
        else if (e1.getTiempoTotal() > e2.getTiempoTotal()) {
            return -1;
        } else if (e1.getTiempoTotal() < e2.getTiempoTotal()) {
            return 0;
        } else return 0;
    }
}

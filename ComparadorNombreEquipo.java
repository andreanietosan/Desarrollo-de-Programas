import java.util.Comparator;

public class ComparadorNombreEquipo implements Comparator<Equipo> {
    public int compare(Equipo e1, Equipo e2) {
        return (e2.getNombreEquipo().compareTo(e1.getNombreEquipo()));
    }
}

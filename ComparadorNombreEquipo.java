import java.util.Comparator;

public class ComparadorNombreEquipo implements Comparator<Equipo> {
    public int compare(Equipo e1, Equipo e2) {

        return (e1.getNombreEquipo().compareTo(e2.getNombreEquipo()));
    }
}

import java.util.Comparator;

public class ComparadorNombreEtapa implements Comparator<Etapa> {
    public int compare(Etapa e1, Etapa e2) {
        return (e2.getNombreEtapa().compareTo(e1.getNombreEtapa()));
    }
}

import java.util.Comparator;

public class ComparadorDistanciaEtapa implements Comparator<Etapa> {
    public int compare(Etapa e1, Etapa e2) {
        if (e1.getDistancia() == e2.getDistancia())
            return new ComparadorNombreEtapa().compare(e1, e2);
        else if (e1.getDistancia() > e2.getDistancia())
            return 1;
        else
            return -1;
    }
}

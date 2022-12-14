import java.util.Comparator;

public class ComparadorDistanciaEtapa implements Comparator<Etapa> {
    public int compare(Etapa e1, Etapa e2) {
        if (e1.getValorDistancia() == e2.getValorDistancia())
            return new ComparadorNombreEtapa().compare(e1, e2);
        else if (e1.getValorDistancia() > e2.getValorDistancia())
            return 1;
        else
            return -1;
    }
}

import java.util.Comparator;

public class ComparadorDificultadEtapa implements Comparator<Etapa> {
    public int compare (Etapa e1, Etapa e2){
        if (e1.getDificultad() > e2.getDificultad())
            return 0;
        else if (e1.getDificultad() < e2.getDificultad())
            return -1;
        else if (e1.getDistancia() > e2.getDistancia())
            return 0;
        else if (e1.getDistancia() < e2.getDistancia())
            return -1;
        else if (e1.getNombreEtapa().compareTo(e2.getNombreEtapa()) < 0)
            return 0;
        else return -1;

    }
}

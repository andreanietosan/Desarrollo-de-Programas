import java.util.Comparator;

public class ComparatorHabilidad implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getHabilidad() > c2.getHabilidad())
            return 0;
        else if (c1.getHabilidad() < c2.getHabilidad())
            return -1;
        else if (c1.getNombreCiclista().compareTo(c2.getNombreCiclista()) < 0)
            return 0;
        else return -1;
    }
}

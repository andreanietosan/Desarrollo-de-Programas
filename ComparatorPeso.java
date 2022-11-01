import java.util.Comparator;

public class ComparatorPeso implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        if (b1.getPeso() > b2.getPeso())
            return 1;
        else if (b1.getPeso() < b2.getPeso())
            return -1;
        else if (b1.getNombreBicicleta().compareTo(b2.getNombreBicicleta()) < 0)
            return 0;
        else return -1;
    }
}

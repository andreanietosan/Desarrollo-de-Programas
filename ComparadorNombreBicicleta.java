import java.util.Comparator;

public class ComparadorNombreBicicleta implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        return (b1.getNombreBicicleta().compareTo(b2.getNombreBicicleta()));
    }
}

import java.util.Comparator;

/**
 * Realiza una comparación entre dos bicicletas a través de su peso descendentemente
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class ComparatorPesoDesc implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        if (b1.getValorPeso() == b2.getValorPeso())
            return new ComparadorNombreBicicleta().compare(b1, b2);
        else if (b1.getValorPeso() < b2.getValorPeso())
            return 1;
        else
            return -1;
    }
}

/**
 * El enum Distancia indica las distintas distancias que puede tener una etapa,
 * CORTA, INTERMEDIA O LARGA.
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public enum Distancia {
    CORTA("Corta", 150.0),
    INTERMEDIA("Intermedia", 200.0),
    LARGA("Larga", 225.0);

    private final String nombre;
    private final double valor;

    Distancia(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return getNombre() + " (valor:" + getValor();
    }
}

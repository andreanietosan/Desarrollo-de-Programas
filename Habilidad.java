/**
 * El enum Habilidad indica las distintas habilidades que puede tener un ciclista,
 * LENTA, NORMAL O BUENA.
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public enum Habilidad {
    LENTA("Lenta", 4.0),
    NORMAL("Normal", 6.0),
    BUENA("Buena", 8.0);

    private final String nombre;
    private final double valor;

    Habilidad(String nombre, double valor) {
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
        return getNombre() + " (valor:" + getValor() + ")";
    }
}

public enum Dificultad {
    SENCILLA("Sencilla", 0.9),
    NORMAL("Normal", 1.0),
    COMPLEJA("Compleja", 1.1);

    private final String nombre;
    private final double valor;

    Dificultad(String nombre, double valor) {
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

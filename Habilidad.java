public enum Habilidad {
    LENTA("LENTA", 90.0),
    NORMAL("NORMAL", 100.0),
    BUENA("BUENA", 110.0),
    CLASEMUNDIAL("CLASEMUNDIAL", 120.0);

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
        return getNombre() + "(original:" + getValor() + ")";
    }
}

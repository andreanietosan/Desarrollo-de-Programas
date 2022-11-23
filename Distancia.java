public enum Distancia {
    CORTA("CORTA", 150),
    INTERMEDIA("INTERMEDIA", 200),
    LARGA("LARGA", 225);

    private final String nombre;
    private final int valor;

    Distancia(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return getNombre() + "(original:" + getValor() + ")";
    }
}

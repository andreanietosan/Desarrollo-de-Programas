public enum Peso {
    LIGERA("LIGERA", 7.35),
    NORMAL("NORMAL", 7.50),
    PESADA("PESADA", 7.85);

    private final String nombre;
    private final double valor;

    Peso(String nombre, double valor) {
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

public enum Peso {
    LIGERA("Ligera", 7.35),
    NORMAL("Normal", 7.50),
    PESADA("Pesada", 7.85);

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
        return getNombre() + " (valor:" + getValor();
    }
}

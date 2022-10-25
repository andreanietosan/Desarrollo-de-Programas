public class Resultado {
    private Etapa etapa;
    private double tiempo;
    private double energia;

    public Resultado(Etapa etapa, double tiempo, double energia) {
        this.etapa = etapa;
        this.tiempo = tiempo;
        this.energia = energia;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }
}

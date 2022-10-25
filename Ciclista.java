public class Ciclista {

    private String nombreCiclista;
    private Bicicleta bicicleta;
    private double habilidad;

    private Resultado resultado; ///clase resultado aparte de la clase ciclista
    private Equipo equipo;

    public Ciclista(String nombreCiclista, Bicicleta bicicleta, double habilidad, Resultado resultado, Equipo equipo) {
        this.nombreCiclista = nombreCiclista;
        this.bicicleta = bicicleta;
        this.habilidad = habilidad;
        this.resultado = resultado;
        this.equipo = equipo;
    }

    public String getNombreCiclista() {
        return nombreCiclista;
    }

    public void setNombreCiclista(String nombreCiclista) {
        this.nombreCiclista = nombreCiclista;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public double getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(double habilidad) {
        this.habilidad = habilidad;
    }


    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public boolean comprobarAbandono() {
        boolean abandono = false;
        if (resultado.getEnergia() <= 0.0)
            abandono = true;
        return abandono;
    }

    public void informeResultado(Bicicleta bicicleta, Etapa etapa) {
        double total_resultado=0.0;
        total_resultado = total_resultado + bicicleta.calcularTiempoNecesario(etapa, this);
    }

    public double getEtapasTerminadas() {
        double etapas = 0;
        if (resultado.getEnergia() > 0)
            etapas++;

        return etapas;
    }

    public double getCarrerasAbandonadas() {
        double etapas = 0;
        if (resultado.getEnergia() < 0)
            etapas++;

        return etapas;
    }

    public double getEnergiaRestantes() {
        double energiaRestante = 0;
        energiaRestante = resultado.getEnergia()- informeResultado(bicicleta,);
        return energiaRestante;
    }

    //<ciclista:LABOUS> <energía: 1150.0> <habilidad: 5.01> <tiempo acumulado sin abandonar: 0.0> <abandonado:false>
    public String toString() {
        return "<ciclista:" + getNombreCiclista() + "> <energía:" + resultado.getEnergia() + "> <habilidad:" + getHabilidad() +  "> <tiempo acumulado sin abandonar:" + informeResultado(bicicleta,) + "> <abandonado:" + comprobarAbandono() + ">";
    }



}

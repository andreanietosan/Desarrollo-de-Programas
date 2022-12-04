public class CiclistaExperimentado extends Ciclista {
    public CiclistaExperimentado(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        super(nombreCiclista, habilidad, energia, equipo);
    }

    @Override
    public double Destreza() {
        //destreza = (((habilidad del Ciclista + 4) / 130) * 10;
        return (double) Math.round((((getValorHabilidad() + 4.0) / 130) * 10) * 100) / 100;
    }

    public String getTipo() {
        return "CiclistaExperimentado";
    }
}

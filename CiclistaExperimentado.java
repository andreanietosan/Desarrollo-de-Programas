/**
 * Clase dedicada al CiclistaExperimentado, subclase de Ciclista, el cuál se diferencia de los demás a través de su forma de calcular la destreza
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class CiclistaExperimentado extends Ciclista {
    /**
     * Constructor por parámetros de la clase CiclistaExperimentado
     */
    public CiclistaExperimentado(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        super(nombreCiclista, habilidad, energia, equipo);
    }

    @Override
    public double Destreza() {
        return (double) Math.round((((getValorHabilidad() + 4.0) / 130) * 10) * 100) / 100;
    }

}

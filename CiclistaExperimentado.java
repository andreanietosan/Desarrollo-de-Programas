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

    /**
     * Redefinicion del metodo equals() en la clase CiclistaExperimentado
     *
     * @return true si los 2 CiclistaExperimentado comparados son iguales, false en otro caso
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof CiclistaExperimentado))
            return false;
        CiclistaExperimentado other = (CiclistaExperimentado) obj;
        return super.equals(other) && getNombreCiclista().equals(other.getNombreCiclista());
    }

    /**
     * Devuelve un valor entero que representa de forma inequívoca a un objeto de la clase CiclistaExperimentado
     *
     * @return un valor entero
     */
    @Override
    public int hashCode() {
        int resultado = 7;
        resultado = 3 * resultado + super.hashCode();
        resultado = 5 * resultado + getNombreCiclista().hashCode();
        return resultado;
    }

}

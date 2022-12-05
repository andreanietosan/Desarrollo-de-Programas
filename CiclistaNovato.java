/**
 * Clase dedicada al CiclistaNovato, subclase de Ciclista, el cuál se diferencia de los demás a través de su forma de calcular la destreza
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class CiclistaNovato extends Ciclista {

    /**
     * Constructor por parámetros de la clase CiclistaNovato
     */
    public CiclistaNovato(String nombreCiclista, Habilidad habilidad, double energia, Equipo equipo) {
        super(nombreCiclista, habilidad, energia, equipo);
    }

    @Override
    public double Destreza() {
        return (double) Math.round((((getValorHabilidad() + 2.0) / 120) * 10) * 100) / 100;
    }

    /**
     * Redefinicion del metodo equals() en la clase CiclistaNovato
     *
     * @return true si los 2 CiclistaNovato comparados son iguales, false en otro caso
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof CiclistaNovato))
            return false;
        CiclistaNovato other = (CiclistaNovato) obj;
        return super.equals(other) && getNombreCiclista().equals(other.getNombreCiclista());
    }

    /**
     * Devuelve un valor entero que representa de forma inequívoca a un objeto de la clase CiclistaNovato
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

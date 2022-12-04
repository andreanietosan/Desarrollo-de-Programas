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

}

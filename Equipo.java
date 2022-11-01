import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * En la clase Ciclista se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Equipo {
    private String nombreEquipo;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicicletas;
    private Comparator compCiclistas;
    private Comparator compBicicletas;

    /**
     * Constructor para objetos de la clase Equipo
     *
     * @param nombreEquipo   Nombre del equipo
     * @param compCiclistas  Comparadores de los ciclistas de cada equipo
     * @param compBicicletas Comparadores de las bicicletas de cada equipo
     */
    public Equipo(String nombreEquipo, Comparator compCiclistas, Comparator compBicicletas) {
        this.nombreEquipo = nombreEquipo;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicicletas = new ArrayList<Bicicleta>();
        this.compCiclistas = compCiclistas;
        this.compBicicletas = compBicicletas;
    }

    /**
     * Devuelve el atributo nombre de la clase Equipo
     *
     * @return El atributo nombre del Equipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Asigna un nombre al Equipo
     *
     * @param nombreEquipo Nombre que se le va asignar al Equipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Devuelve
     *
     * @return
     */
    public ArrayList<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public ArrayList<Ciclista> getCiclistasAbandonados() {
        return ciclistasAbandonados;
    }

    public void setCiclistasAbandonados(ArrayList<Ciclista> ciclistasAbandonados) {
        this.ciclistasAbandonados = ciclistasAbandonados;
    }

    public ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }

    public void asignarBicicleta(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    public double getTiempoTotal() {
        double tiempo = 0;
        for (Ciclista c : ciclistas)
            tiempo += c.getTiempoTerminadas();
        return tiempo;
    }

    public void ordenarCiclistas() {
        Collections.sort(ciclistas, this.compCiclistas);
    }

    public void ordenarBicicletas() {
        Collections.sort(bicicletas, this.compBicicletas);
    }

    public void anadirBicicleta(Bicicleta b) {
        bicicletas.add(b);
    }

    public void anadirCiclista(Ciclista c) {
        ciclistas.add(c);
    }

    public void anadirCiclistaAbandonado(Ciclista c) {
        ciclistasAbandonados.add(c);
    }


    public double calcularMediaEquipo() {
        double media = 0;
        for (Ciclista c : getCiclistas())
            media += c.getTiempoTerminadas();
        media /= getCiclistas().size();
        return (double) Math.round(media * 100) / 100;
    }

    public String toString() {
        return "%%% " + getNombreEquipo() + " %%% Media Minutos de Ciclistas sin abandonar " + getTiempoTotal() + " %%%";
    }
}

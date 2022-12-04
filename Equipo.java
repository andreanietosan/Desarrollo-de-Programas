import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * En la clase EquipoInterface se encuentra toda la información de esta
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Equipo implements EquipoInterface {
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

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

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
        int numCiclista = 0;
        for (Ciclista c : getCiclistas())
            if (!c.comprobarAbandono()) {
                media += c.getTiempoTerminadas();
                numCiclista += 1;
            }
        media /= numCiclista;
        return (double) Math.round(media * 100) / 100;
    }

    public ArrayList<Ciclista> enviarACarrera() {
        ArrayList<Ciclista> aux = new ArrayList<>();
        int contBici=0;
        for (Ciclista ciclista : ciclistas) {
            if (!ciclista.comprobarAbandono()){
                ciclista.setBicicleta(bicicletas.get(contBici));
                aux.add(ciclista);
                contBici+=1;
            }
            else
                anadirCiclistaAbandonado(ciclista);
        }
        return aux;
    }

    /**
     * Muestra en una cadena los atributos del equipo
     *
     * @return Un string con los atributos y características principales del equipo
     */
    public String toString() {
        return "%%% " + getNombreEquipo() + " %%% Media Minutos de Ciclistas sin abandonar " + getTiempoTotal() + " %%%";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Etapa))
            return false;
        Equipo other = (Equipo) obj;
        return getNombreEquipo().equals(other.getNombreEquipo());
    }
}

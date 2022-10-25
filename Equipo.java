import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Equipo {
    private String nombreEquipo;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicicletas;
    private Comparator<Ciclista> compCiclistas;
    boolean descCiclista;
    private Comparator<Bicicleta> compBicicletas;
    boolean descBicicleta;

    public Equipo(String nombreEquipo, Comparator<Ciclista> compCiclistas, boolean descCiclista, Comparator<Bicicleta> compBicicletas, boolean descBicicleta) {
        this.nombreEquipo = nombreEquipo;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicicletas = new ArrayList<Bicicleta>();
        this.compCiclistas = compCiclistas;
        this.descCiclista = descCiclista;
        this.compBicicletas = compBicicletas;
        this.descBicicleta = descBicicleta;
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

    public void setCompCiclistas(Comparator<Ciclista> compCiclistas, boolean desc) {
        this.compCiclistas = compCiclistas;
        this.descCiclista = desc;
    }

    public void setCompBicicletas(Comparator<Bicicleta> compBicicletas, boolean desc) {
        this.compBicicletas = compBicicletas;
        this.descBicicleta = desc;
    }


    public void ordenarCiclista()
    {
        if (descCiclista)
            Collections.sort(ciclistas,Collections.reverseOrder(compCiclistas));
        else
            Collections.sort(ciclistas,compCiclistas);
    }

    public void ordenarBicicleta()
    {
        if (descBicicleta)
            Collections.sort(bicicletas,Collections.reverseOrder(compBicicletas));
        else
            Collections.sort(bicicletas,compBicicletas);
    }



}

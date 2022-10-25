import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.*;
/**
 * Clase que organiza las carreras del campeonato de equipos en las etapas que sean necesarias 
 * 
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Organizacion {
    private List<Etapa> etapas; //Etapas del campeonato

    /**
     * Constructor para objetos de la clase Organizacion
     */
    public Organizacion() {
        etapas = new ArrayList<Etapa>();
    }

    /**
     * Se añade una etapa a las etapas del campeonato 
     * 
     * @param e     Etapa que se va añadir en el campeonato
     */
    public void anadirEtapa(Etapa e) {
        etapas.add(e);
    }

    private void mostrarEtapas()
    {
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (Etapa etapa:etapas) {
            System.out.println(etapa.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

    }

}

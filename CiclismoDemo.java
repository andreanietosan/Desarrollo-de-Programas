
import java.lang.*;
import java.util.*;
/**
 * Main simulation class. 
 * First, initial data are loaded. 
 * Then, while not end of the simulation, the actions will be performed.
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 * @version 22/23
 */
public class CiclismoDemo
{
    public static void main(String[] args) {
        Organizacion organizacion=new Organizacion(new ComparadorDificultadEtapa());
        DatosCampeonatoCompleto initData = new DatosCampeonatoCompleto(organizacion);
        //DatosCampeonatoAbandonos initdata = new DatosCampeonatoAbandonos(organizacion);
            
        organizacion.gestionarCampeonato();
    }    

}


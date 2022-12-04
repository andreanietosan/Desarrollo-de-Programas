import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.*;
import java.util.Iterator;

/**
 * Clase que organiza las carreras del campeonato de equipos en las etapas que sean necesarias
 *
 * @author (Andrea Nieto Sánchez, Ismael Rodríguez Velarde)
 */
public class Organizacion {
    private Set<Etapa> etapas; //Etapas del campeonato
    private List<Equipo> equipos; //Equipos que se han inscrito
    private HashMap<Ciclista, Equipo> ciclCarrera;
    private List<Ciclista> ciclistaCarreraAbandonados;
    private Comparator compEtapas;
    private Comparator compTiempoCiclistas;

    /**
     * Constructor para objetos de la clase Organizacion
     *
     * @param compEtapas Comparador de etapas
     */
    public Organizacion(Comparator compEtapas) {
        etapas = new TreeSet<Etapa>(compEtapas);
        equipos = new ArrayList<Equipo>();
        ciclCarrera = new HashMap<>();
        ciclistaCarreraAbandonados = new ArrayList<Ciclista>();
        //this.compEtapas = compEtapas;
        compTiempoCiclistas = compTiempoCiclistas;
    }

    /**
     * Se añade una etapa a las etapas del campeonato
     *
     * @param e Etapa que se va añadir en el campeonato
     */
    public void anadirEtapa(Etapa e) {
        etapas.add(e);
    }

    /**
     * Se añade un equipo a los equipos del campeonato
     *
     * @param eq Equipo que se va añadir en el campeonato
     */
    public void inscribirEquipo(Equipo eq) {
        equipos.add(eq);
    }

    /**
     * Devuelve la lista de equipos de la organización
     *
     * @return lista de equipos
     */
    public List<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * Ordena los equipos que van a competir
     */
    public void ordenarEquipos() {
        Collections.sort(equipos, new ComparadorEquipos());
    }

    /**
     * Muestra los ciclistas y sus equipos que van a competir.
     * Este método es usado en las pruebas
     */
    public void mostrarCiclistas() {
        Iterator it = ciclCarrera.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry datos = (Map.Entry) it.next(); //dato contiene la entrada del haspmap // key(ciclista) valor(equipo)
            Ciclista ciclista = (Ciclista) datos.getKey(); //la entrada se ha declarado con este nombre (datos.getkey)
            Equipo equipo = (Equipo) datos.getValue();
            System.out.println("Ciclista: " + ciclista.getNombreCiclista() + " Equipo: " + equipo.getNombreEquipo());
        }
    }

    /**
     * Muestra las etapas que tiene la competición
     */
    public void mostrarEtapas() {
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (Etapa etapa : etapas) {
            System.out.println(etapa.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

    }

    /**
     * Muestra los equipos que van a competir al inicializar la competición
     */
    public void mostrarEquipos() {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        for (Equipo equipo : equipos) {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println(equipo.toString());
            System.out.println();
            for (Ciclista c : equipo.getCiclistas())
                System.out.println(c.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }

    /**
     * Muestra los equipos al finalizar la competición
     */
    public void mostrarEquiposFinal() {
        for (Equipo e : equipos) {
            e.ordenarCiclistas();
            e.ordenarBicicletas();
        }
        System.out.println("****************************************************");
        System.out.println("******** CLASIFICACIÓN FINAL DE EQUIPOS *********");
        System.out.println("****************************************************");
        for (int i = 0; i < equipos.size(); i++) {
            int a = i + 1;
            System.out.println(" @@@ Posición(" + a + ") " + equipos.get(i).getNombreEquipo() + " con " + equipos.get(i).calcularMediaEquipo() + " minutos de media @@@");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%%" + equipos.get(i).getNombreEquipo() + " %%%Media Minutos de Ciclistas sin abandonar " + equipos.get(i).calcularMediaEquipo() + " %%%");
            System.out.println();
            for (Ciclista c : equipos.get(i).getCiclistas())
                if (!c.comprobarAbandono())
                    System.out.println(c.toString());
            for (Ciclista c : equipos.get(i).getCiclistas())
                if (c.comprobarAbandono())
                    System.out.println(c.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }

    /**
     * Recibe a los ciclistas que vana competir que son enviados de sus equipos
     */
    public void recibir() {
        ArrayList<Ciclista> listaCiclistasEquipos = new ArrayList<>();
        for (Equipo equipo : equipos) {
            listaCiclistasEquipos = equipo.enviarACarrera();
            for (Ciclista ciclista : listaCiclistasEquipos)
                ciclCarrera.put(ciclista, equipo);
        }
    }

    /**
     * Muestra la clasificación final de los ciclistas que han competido
     */
    public void mostrarCiclistasFinal() {
        //lista auxiliar para reordenar los ciclistas
        ArrayList<Ciclista> ciclistaCarrera = new ArrayList<>();
        ciclistaCarrera.clear();

        //iterador necesario para recorrer el HashMap
        Iterator it = ciclCarrera.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry datos = (Map.Entry) it.next(); //dato contiene la entrada del haspmap // key(ciclista) valor(equipo)
            Ciclista ciclista = (Ciclista) datos.getKey(); //la entrada se ha declarado con este nombre (datos.getkey)
            ciclistaCarrera.add(ciclista);
        }

        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE CICLISTAS **********");
        System.out.println("****************************************************");

        Collections.sort(ciclistaCarrera, new ComparadorTiempoCiclista().reversed());
        int a = 1;
        for (int k = ciclistaCarrera.size() - 1; k >= 0; k--) {
            if (!ciclistaCarrera.get(k).comprobarAbandono()) {
                System.out.println("@@@ Posición(" + a + "): " + ciclistaCarrera.get(k).getNombreCiclista() + "- Tiempo Total: " + ciclistaCarrera.get(k).getTiempoTerminadas() + " @@@");
                for (Etapa etapa : etapas) {
                    System.out.println("Carrera(" + etapa.getNombreEtapa() + ") - Tiempo: " + ciclistaCarrera.get(k).getResultado(etapa).getTiempo() + " minutos");
                }
                System.out.println();
                a += 1;
            }
        }
        if (!ciclistaCarreraAbandonados.isEmpty()) {
            System.out.println("****************************************************");
            System.out.println("************** CICLISTAS QUE ABANDONARON **************");
            System.out.println("****************************************************");
            Collections.sort(ciclistaCarreraAbandonados, new ComparadorTiempoCiclista());
            for (int k = 0; k < ciclistaCarreraAbandonados.size(); k++) {
                System.out.println("--- ciclista Abandonado: " + ciclistaCarreraAbandonados.get(k).getNombreCiclista() + " - Puntos Totales Anulados: " + ciclistaCarreraAbandonados.get(k).getTiempoTerminadas() + " ---");
                for (Etapa etapa : etapas) {
                    if (ciclistaCarreraAbandonados.get(k).resultadoEtapaAbandono(etapa))
                        System.out.println("Carrera(" + etapa.getNombreEtapa() + ") - Tiempo: " + ciclistaCarreraAbandonados.get(k).getResultado(etapa).getTiempo() + " minutos");
                }
                System.out.println();
            }
        }
    }

    /**
     * En este método se realiza toda la competición de la organización
     */
    public void competicion() {
        //lista auxiliar para reordenar los ciclistas
        ArrayList<Ciclista> ciclistaCarrera = new ArrayList<>();
        ArrayList<Ciclista> ciclistasAbandonosEnEtapas = new ArrayList<>();

        int carrera = 0;
        for (Etapa etapa : etapas) {
            for (int j = 0; j < equipos.size(); j++) {
                equipos.get(j).ordenarCiclistas();
                equipos.get(j).ordenarBicicletas();
            }
            ciclistaCarrera.clear();
            ciclistasAbandonosEnEtapas.clear();
            ciclCarrera.clear();
            //solo tengo los ciclistas del map
            //ciclistaCarrera= ciclCarrera.keySet();

            recibir();

            //iterador necesario para recorrer el HashMap
            Iterator it = ciclCarrera.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry datos = (Map.Entry) it.next(); //dato contiene la entrada del haspmap // key(ciclista) valor(equipo)
                Ciclista ciclista = (Ciclista) datos.getKey(); //la entrada se ha declarado con este nombre (datos.getkey)
                ciclistaCarrera.add(ciclista);
            }

            if (ciclistaCarrera.isEmpty())
                System.out.println("CAMPEONATO DESIERTO");
            else {

                carrera += 1;
                System.out.println();
                System.out.println("********************************************************************************************************");
                System.out.println("*** CARRERA<" + carrera + "> EN <etapa:" + etapa.getNombreEtapa() + "> <dificultad: " + etapa.getDificultad() + "> <distancia: " + etapa.getDistancia() + ")> ***");
                System.out.println("********************************************************************************************************");
                System.out.println("********************************************************************************************************");
                System.out.println("******************************** Ciclistas que van a competir en " + etapa.getNombreEtapa() + " *******************************");
                System.out.println("**********************************************************************************************************");


                Collections.sort(ciclistaCarrera, new ComparadorTiempoCiclista().reversed());

                for (Ciclista c : ciclistaCarrera) {
                    c.setTiempoEtapa(c.getBicicleta().calcularTiempoNecesario(etapa, c));
                    System.out.println(c.toString());
                }

                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + etapa.getNombreEtapa() + " ++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                for (int j = 0; j < ciclistaCarrera.size(); j++) {
                    int corredor = j + 1;

                    System.out.println("@@@ ciclista " + corredor + " de " + ciclistaCarrera.size());
                    ciclistaCarrera.get(j).correr(etapa);
                }

                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++ Clasificación final de la carrera en " + etapa.getNombreEtapa() + " ++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                for (Ciclista c : ciclistaCarrera)
                    if (c.comprobarAbandono()) {
                        ciclistasAbandonosEnEtapas.add(c);
                        ciclistaCarreraAbandonados.add(c);
                    }
                Collections.sort(ciclistaCarrera, new ComparadorTiempoEtapa().reversed());

                int a = 1;
                for (int k = ciclistaCarrera.size() - 1; k >= 0; k--) {
                    if (!ciclistaCarrera.get(k).comprobarAbandono()) {
                        System.out.println("@@@ Posición(" + a + "): " + ciclistaCarrera.get(k).getNombreCiclista() + " - Tiempo: " + ciclistaCarrera.get(k).getTiempoEtapa() + " minutos @@@");
                        a += 1;
                    }
                }
                for (Ciclista c : ciclistasAbandonosEnEtapas)
                    System.out.println("¡¡¡ Ha abandonado " + c.getNombreCiclista() + " - Tiempo: " + c.getEnergia() + " - Además ha abandonado para el resto del Campeonato !!!");
            }
        }

    }

    /**
     * Gestiona todo el campeonato
     */
    public void gestionarCampeonato() {
        mostrarEtapas();
        mostrarEquipos();
        competicion();
        mostrarCiclistasFinal();
        ordenarEquipos();
        mostrarEquiposFinal();
    }

}

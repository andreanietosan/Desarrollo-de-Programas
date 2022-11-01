import java.awt.*;
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
    private List<Equipo> equipos; //Equipos que se han inscrito
    private List<Ciclista> ciclistaCarrera;
    private Comparator compEtapas;
    private Comparator compTiempoCiclistas;

    /**
     * Constructor para objetos de la clase Organizacion
     */
    public Organizacion(Comparator compEtapas) {
        etapas = new ArrayList<Etapa>();
        equipos = new ArrayList<Equipo>();
        ciclistaCarrera = new ArrayList<Ciclista>();
        this.compEtapas = compEtapas;
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

    public void inscribirEquipo(Equipo eq) {
        equipos.add(eq);
    }

    public void ordenarEtapas() {
        Collections.sort(etapas, this.compEtapas);
    }

    public void ordenarEquipos() {
        Collections.sort(equipos, new ComparadorEquipos());
    }

    public void ordenarCiclistas() {
        Collections.sort(ciclistaCarrera, new ComparadorTiempoCiclista());
    }

    public void mostrarEtapas() {
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (Etapa etapa : etapas) {
            System.out.println(etapa.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

    }

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

    public void mostrarEquiposFinal() {
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
                System.out.println(c.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }

    public void elegir() {
        for (Equipo equipo : equipos) {
            for (int i = 0; i < equipo.getCiclistas().size(); i++) {
                if (!equipo.getCiclistas().get(i).comprobarAbandono()) {
                    Ciclista cic = equipo.getCiclistas().get(i);
                    cic.setBicicleta(equipo.getBicicletas().get(i));
                    ciclistaCarrera.add(cic);
                } else {
                    Ciclista cic = equipo.getCiclistas().get(i);
                    equipo.anadirCiclistaAbandonado(cic);
                }
            }
        }
    }

    public void competicion() {
        for (int i = 0; i < etapas.size(); i++) {
            for (int j = 0; j < equipos.size(); j++) {
                equipos.get(j).ordenarCiclistas();
                equipos.get(j).ordenarBicicletas();
            }
            elegir();

            if (ciclistaCarrera.isEmpty())
                System.out.println("CAMPEONATO DESIERTO");
            else {

                int carrera = i + 1;
                System.out.println();
                System.out.println("********************************************************************************************************");
                System.out.println("*** CARRERA<" + carrera + "> EN <etapa:" + etapas.get(i).getNombreEtapa() + "> <dificultad: " + etapas.get(i).getDificultad() + "> <distancia: " + etapas.get(i).getDistancia() + ")> ***");
                System.out.println("********************************************************************************************************");
                System.out.println("********************************************************************************************************");
                System.out.println("******************************** Ciclistas que van a competir en " + etapas.get(i).getNombreEtapa() + " *******************************");
                System.out.println("**********************************************************************************************************");

                ordenarCiclistas();
                for (Ciclista c : ciclistaCarrera)
                    System.out.println(c.toString());

                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + etapas.get(i).getNombreEtapa() + " ++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                for (int j = 0; j < ciclistaCarrera.size(); j++) {
                    int corredor = j + 1;

                    System.out.println("@@@ ciclista " + corredor + " de " + ciclistaCarrera.size());
                    System.out.print(ciclistaCarrera.get(j).toString());
                    System.out.println(" con bicicleta");
                    System.out.print(ciclistaCarrera.get(j).getBicicleta().toString());
                    double tiempoEmpleado = ciclistaCarrera.get(j).getEnergia();
                    System.out.println(" en etapa " + etapas.get(i).getNombreEtapa());
                    System.out.println("+++ Con estas condiciones el ciclista " + ciclistaCarrera.get(j).getNombreCiclista() + " con la bicicleta " + ciclistaCarrera.get(j).getBicicleta().getNombreBicicleta() + " alcanza una velocidadad de " + ciclistaCarrera.get(j).getBicicleta().calcularVelocidad(ciclistaCarrera.get(j), etapas.get(i)) + " km/hora +++");
                    System.out.println("+++ " + ciclistaCarrera.get(j).getNombreCiclista() + " termina la etapa en " + ciclistaCarrera.get(j).getBicicleta().calcularTiempoNecesario(etapas.get(i), ciclistaCarrera.get(j)) + " minutos +++");
                    ciclistaCarrera.get(j).participar(ciclistaCarrera.get(j).getBicicleta().calcularTiempoNecesario(etapas.get(i), ciclistaCarrera.get(j)), etapas.get(i));
                    if (tiempoEmpleado < ciclistaCarrera.get(j).getBicicleta().calcularTiempoNecesario(etapas.get(i), ciclistaCarrera.get(j))) {
                        System.out.println("¡¡¡ El ciclista " + ciclistaCarrera.get(j).getNombreCiclista() + " se quedó sin energia a falta de " + ciclistaCarrera.get(j).getEnergia() + " minutos para terminar !!!");
                        System.out.println("¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + tiempoEmpleado + " minutos !!!");
                    }
                    System.out.println("+++ La energía del ciclista " + ciclistaCarrera.get(j).getNombreCiclista() + " tras la carrera es " + ciclistaCarrera.get(j).getEnergia() + " +++");
                    System.out.println("@@@");
                }

                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++ Clasificación final de la carrera en " + etapas.get(i).getNombreEtapa() + " ++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                ordenarCiclistas();
                int a = 1;
                for (int k = ciclistaCarrera.size() - 1; k >= 0; k--) {
                    if (!ciclistaCarrera.get(k).comprobarAbandono()) {
                        System.out.println("@@@ Posición(" + a + "): " + ciclistaCarrera.get(k).getNombreCiclista() + " - Tiempo: " + ciclistaCarrera.get(k).getBicicleta().calcularTiempoNecesario(etapas.get(i), ciclistaCarrera.get(k)) + " minutos @@@");
                        a += 1;
                    }
                }
                for (int k = ciclistaCarrera.size() - 1; k >= 0; k--) {
                    if (ciclistaCarrera.get(k).comprobarAbandono()) {
                        System.out.println("¡¡¡ Ha abandonado " + ciclistaCarrera.get(k).getNombreCiclista() + " - Tiempo: " + ciclistaCarrera.get(k).getEnergia() + " - Además ha abandonado para el resto del Campeonato !!!");
                    }
                }

                if (i != etapas.size() - 1)
                    ciclistaCarrera.clear();
            }
        }

        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE CICLISTAS **********");
        System.out.println("****************************************************");

        ordenarCiclistas();
        int a = 1;
        for (int k = ciclistaCarrera.size() - 1; k >= 0; k--) {
            if (!ciclistaCarrera.get(k).comprobarAbandono()) {
                System.out.println("@@@ Posición(" + a + "): " + ciclistaCarrera.get(k).getNombreCiclista() + "- Tiempo Total: " + ciclistaCarrera.get(k).getTiempoTerminadas() + " @@@");
                for (int i = 0; i < etapas.size(); i++) {
                    int carrera = i + 1;
                    System.out.println("Carrera(" + etapas.get(i).getNombreEtapa() + ") - Tiempo: " + ciclistaCarrera.get(k).getBicicleta().calcularTiempoNecesario(etapas.get(i), ciclistaCarrera.get(k)) + " minutos");
                }
                System.out.println();
                a += 1;
            }
            if (ciclistaCarrera.get(k).comprobarAbandono()) {
                System.out.println("****************************************************");
                System.out.println("************** CICLISTAS QUE ABANDONARON **************");
                System.out.println("****************************************************");
                System.out.println("--- ciclista Abandonado: " + ciclistaCarrera.get(k).getNombreCiclista() + " - Puntos Totales Anulados: " + ciclistaCarrera.get(k).getTiempoTerminadas() + " ---");
                for (int i = 0; i < etapas.size(); i++) {
                    int carrera = i + 1;
                    System.out.println("Carrera(" + etapas.get(i).getNombreEtapa() + ") - Tiempo: " + ciclistaCarrera.get(k).getBicicleta().calcularTiempoNecesario(etapas.get(i), ciclistaCarrera.get(k)) + " minutos");
                }
                System.out.println();
            }
        }
        ordenarEquipos();
        mostrarEquiposFinal();

    }

    public void gestionarCampeonato() {
        mostrarEtapas();
        mostrarEquipos();
        competicion();
    }

}

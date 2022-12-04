import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * The test class EquipoTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EquipoTest {
    private Equipo equipo;
    private Equipo equipo2,equipo3;
    private CiclistaNovato ciclista1; //wiebes
    private CiclistaEstrella ciclista2; //balsamo
    private CiclistaExperimentado ciclista3;
    private BicicletaNormal bicicleta1;
    private BicicletaNormal bicicleta2;
    private BicicletaNormal bicicleta3;
    private Etapa etapa1;
    private Etapa etapa2;
    private ArrayList<Resultado> resultado;
    private Resultado res1,res2,res3,res4;



    /**
     * Default constructor for test class EquipoTest
     */
    public EquipoTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        etapa1 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        etapa2 = new Etapa("normal intermedia", Dificultad.NORMAL, Distancia.INTERMEDIA);

        equipo = new Equipo("Movistar Women", new ComparatorHabilidad(), new ComparatorPeso());

        equipo2= new Equipo("DSM Women", new ComparatorEnergia(), new ComparatorPeso());
        equipo3= new Equipo("Trek Segafredo Women", new ComparatorEnergia(), new ComparatorPeso());

        resultado = new ArrayList<Resultado>();

        ciclista1 = new CiclistaNovato("WIEBES", Habilidad.NORMAL, 1190, equipo);
        ciclista2 = new CiclistaEstrella("BALSAMO", Habilidad.NORMAL, 1180, equipo);
        ciclista3 = new CiclistaExperimentado("NORSGAARD", Habilidad.NORMAL, 0, equipo);

        equipo.anadirCiclista(ciclista1);
        equipo.anadirCiclista(ciclista2);
        equipo.anadirCiclista(ciclista3);

        equipo2.anadirCiclista(ciclista1);
        equipo2.anadirCiclista(ciclista2);
        equipo3.anadirCiclista(ciclista1);
        equipo3.anadirCiclista(ciclista2);

        bicicleta1 = new BicicletaNormal("SCOTT CONTESSA ADDICT 15", Peso.NORMAL);
        bicicleta2 = new BicicletaNormal("TREK Madone SLR 9 eTap Gen 7", Peso.LIGERA);
        bicicleta3 = new BicicletaNormal("CANYON Aeroad CF SLX 8 Disc Di2", Peso.NORMAL);

        equipo.anadirBicicleta(bicicleta1);
        equipo.anadirBicicleta(bicicleta2);
        equipo.anadirBicicleta(bicicleta3);

        equipo2.anadirBicicleta(bicicleta1);
        equipo2.anadirBicicleta(bicicleta2);
        equipo3.anadirBicicleta(bicicleta1);
        equipo3.anadirBicicleta(bicicleta2);

        ciclista1.setBicicleta(bicicleta1);
        ciclista2.setBicicleta(bicicleta2);
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void PruebaCalcularMediaEquipo() {


        res1 = new Resultado(etapa1,ciclista1.getBicicleta().calcularTiempoNecesario(etapa1, ciclista1),true);
        resultado.add(res1);
        ciclista1.setResultados(resultado);


        res2 = new Resultado(etapa2,ciclista1.getBicicleta().calcularTiempoNecesario(etapa2, ciclista1),true);
        resultado.add(res2);
        ciclista1.setResultados(resultado);


        res3 = new Resultado(etapa1,ciclista2.getBicicleta().calcularTiempoNecesario(etapa1, ciclista2),true);
        resultado.add(res3);
        ciclista1.setResultados(resultado);


        res4 = new Resultado(etapa2,ciclista1.getBicicleta().calcularTiempoNecesario(etapa2, ciclista1),true);
        resultado.add(res4);
        ciclista1.setResultados(resultado);

        assertEquals(283.65, equipo.calcularMediaEquipo());
    }

    @Test
    public void PruebaOrdenarCiclistas(){
        equipo2.ordenarCiclistas();
        equipo3.ordenarCiclistas();

        assertEquals(equipo2.getCiclistas().get(0).getNombreCiclista(),equipo3.getCiclistas().get(0).getNombreCiclista());
        assertEquals(equipo2.getCiclistas().get(1).getNombreCiclista(),equipo3.getCiclistas().get(1).getNombreCiclista());
    }

    @Test
    public void PruebaOrdenarBicicletas(){
        equipo2.ordenarBicicletas();
        equipo3.ordenarBicicletas();

        assertEquals(equipo2.getBicicletas().get(0).getNombreBicicleta(),equipo3.getBicicletas().get(0).getNombreBicicleta());
        assertEquals(equipo2.getBicicletas().get(1).getNombreBicicleta(),equipo3.getBicicletas().get(1).getNombreBicicleta());
    }

//    public ArrayList<Ciclista> enviarACarrera() {
//        ArrayList<Ciclista> aux = new ArrayList<>();
//        int contBici=0;
//        for (Ciclista ciclista : ciclistas) {
//            if (!ciclista.comprobarAbandono()){
//                ciclista.setBicicleta(bicicletas.get(contBici));
//                aux.add(ciclista);
//                contBici+=1;
//            }
//            else
//                anadirCiclistaAbandonado(ciclista);
//        }
//        return aux;
//    }
    @Test
    public void PruebaEnviarACarrera(){
        ArrayList<Ciclista> aux = new ArrayList<>();
        aux = equipo.enviarACarrera();
        //comprobamos que envia los ciclistas que no estan abandonados
        assertEquals(2, aux.size());
        //comprobamos los nombres de los ciclistas enviados no abandonados
        assertEquals("WIEBES", aux.get(0).getNombreCiclista());
        assertEquals("BALSAMO", aux.get(1).getNombreCiclista());
    }
}

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
    private CiclistaNovato ciclista1; //wiebes
    private CiclistaEstrella ciclista2; //balsamo
    private BicicletaNormal bicicleta1;
    private BicicletaNormal bicicleta2;
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

        resultado = new ArrayList<Resultado>();

        ciclista1 = new CiclistaNovato("WIEBES", Habilidad.NORMAL, 1190, equipo);
        ciclista2 = new CiclistaEstrella("BALSAMO", Habilidad.NORMAL, 1180, equipo);

        equipo.anadirCiclista(ciclista1);
        equipo.anadirCiclista(ciclista2);

        bicicleta1 = new BicicletaNormal("SCOTT CONTESSA ADDICT 15", Peso.NORMAL);
        bicicleta2 = new BicicletaNormal("TREK Madone SLR 9 eTap Gen 7", Peso.LIGERA);

        equipo.anadirBicicleta(bicicleta1);
        equipo.anadirBicicleta(bicicleta2);

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

        ciclista1.setTiempoEtapa(ciclista1.getBicicleta().calcularTiempoNecesario(etapa1, ciclista1));
        res1 = new Resultado(etapa1,ciclista1.getBicicleta().calcularTiempoNecesario(etapa1, ciclista1),true);
        resultado.add(res1);
        ciclista1.setResultados(resultado);

        ciclista1.setTiempoEtapa(ciclista1.getBicicleta().calcularTiempoNecesario(etapa2, ciclista1));
        res2 = new Resultado(etapa2,ciclista1.getBicicleta().calcularTiempoNecesario(etapa2, ciclista1),true);
        resultado.add(res2);
        ciclista1.setResultados(resultado);

        ciclista2.setTiempoEtapa(ciclista2.getBicicleta().calcularTiempoNecesario(etapa1, ciclista2));
        res3 = new Resultado(etapa1,ciclista2.getBicicleta().calcularTiempoNecesario(etapa1, ciclista2),true);
        resultado.add(res3);
        ciclista1.setResultados(resultado);

        ciclista2.setTiempoEtapa(ciclista2.getBicicleta().calcularTiempoNecesario(etapa2, ciclista2));
        res4 = new Resultado(etapa2,ciclista1.getBicicleta().calcularTiempoNecesario(etapa2, ciclista1),true);
        resultado.add(res4);
        ciclista1.setResultados(resultado);

        assertEquals(283.65, equipo.calcularMediaEquipo());
    }
}

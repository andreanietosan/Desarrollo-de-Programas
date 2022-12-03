import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaNormalTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BicicletaNormalTest {
    private BicicletaNormal bicicleta1;
    private BicicletaNormal bicicleta2;
    private BicicletaNormal bicicleta3;

    private CiclistaNovato ciclista1; //wiebes
    private CiclistaEstrella ciclista2; //balsamo
    private CiclistaEstrella ciclista3; //van

    private Equipo e1;//dsWomen
    private Equipo e2;
    private Equipo e3;
    private Etapa etapa;

    /**
     * Default constructor for test class BicicletaNormalTest
     */
    public BicicletaNormalTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        etapa = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);

        e1 = new Equipo("DSM Women", new ComparatorEnergia(), new ComparatorPeso());
        e2 = new Equipo("Trek Segafredo Women", new ComparatorHabilidad().reversed(), new ComparatorPeso().reversed());
        e3 = new Equipo("Movistar Women", new ComparatorHabilidad(), new ComparatorPeso());

        bicicleta1 = new BicicletaNormal("SCOTT CONTESSA ADDICT 15", Peso.NORMAL);
        bicicleta2 = new BicicletaNormal("TREK Madone SLR 9 eTap Gen 7", Peso.LIGERA);
        bicicleta3 = new BicicletaNormal("CANYON Aeroad CF SLX 8 Disc Di2", Peso.NORMAL);

        ciclista1 = new CiclistaNovato("WIEBES", Habilidad.NORMAL, 1190, e1);
        ciclista2 = new CiclistaEstrella("BALSAMO", Habilidad.NORMAL, 1180, e2);
        ciclista3 = new CiclistaEstrella("VAN VLEUTEN", Habilidad.NORMAL, 1200, e3);
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
    public void PruebaCalcularVelocidad() {
        assertEquals(88.89, bicicleta1.calcularVelocidad(ciclista1, etapa));
        assertEquals(90.70, bicicleta2.calcularVelocidad(ciclista2, etapa));
        assertEquals(88.89, bicicleta3.calcularVelocidad(ciclista3, etapa));

    }

    @Test
    public void PruebaCalcularTiempoNecesario(){
        assertEquals(135.00,bicicleta1.calcularTiempoNecesario(etapa,ciclista1));
        assertEquals(132.30,bicicleta2.calcularTiempoNecesario(etapa,ciclista2));
        assertEquals(135.00,bicicleta3.calcularTiempoNecesario(etapa,ciclista3));

    }


}

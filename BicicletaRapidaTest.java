

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaRapidaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BicicletaRapidaTest
{
    private BicicletaRapida bicicleta1;
    private BicicletaRapida  bicicleta2;
    private BicicletaRapida  bicicleta3;

    private CiclistaNovato ciclista1; //wiebes
    private CiclistaEstrella ciclista2; //balsamo
    private CiclistaEstrella ciclista3; //van

    private Equipo e1;//dsWomen
    private Equipo e2;
    private Equipo e3;
    private Etapa etapa;
    /**
     * Default constructor for test class BicicletaRapidaTest
     */
    public BicicletaRapidaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        etapa = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);

        e1 = new Equipo("DSM Women", new ComparatorEnergia(), new ComparatorPeso());
        e2 = new Equipo("Trek Segafredo Women", new ComparatorHabilidad().reversed(), new ComparatorPeso().reversed());
        e3 = new Equipo("Movistar Women", new ComparatorHabilidad(), new ComparatorPeso());

        bicicleta1 = new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15", Peso.LIGERA, 0.3);
        bicicleta2 = new BicicletaRapida("TREK Emonda SLR 9 eTap", Peso.NORMAL, 0.5);
        bicicleta3 = new BicicletaRapida("CANYON Ultimate CFR eTap", Peso.LIGERA, 0.4);

        ciclista1 = new CiclistaNovato("WIEBES", Habilidad.NORMAL, 1190, e1);
        ciclista2 = new CiclistaEstrella("BALSAMO", Habilidad.NORMAL, 1180, e2);
        ciclista3 = new CiclistaEstrella("VAN VLEUTEN", Habilidad.NORMAL, 1200, e3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void PruebaCalcularVelocidad() {
        assertEquals(91.0, bicicleta1.calcularVelocidad(ciclista1, etapa));
        assertEquals(89.39, bicicleta2.calcularVelocidad(ciclista2, etapa));
        assertEquals(91.1, bicicleta3.calcularVelocidad(ciclista3, etapa));
    }

    @Test
    public void PruebaCalcularTiempoNecesario(){
        assertEquals(131.87,bicicleta1.calcularTiempoNecesario(etapa,ciclista1));
        assertEquals(134.24,bicicleta2.calcularTiempoNecesario(etapa,ciclista2));
        assertEquals(131.72,bicicleta3.calcularTiempoNecesario(etapa,ciclista3));
    }
}

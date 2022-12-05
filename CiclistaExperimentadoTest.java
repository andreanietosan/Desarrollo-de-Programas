

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * The test class CiclistaExperimentadoTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CiclistaExperimentadoTest {
    private CiclistaExperimentado c1;
    private CiclistaExperimentado c2;
    private CiclistaExperimentado c3;
    private BicicletaNormal b1;
    private BicicletaNormal b2;
    private BicicletaNormal b3;
    private Equipo e1;
    private Equipo e2;
    private Equipo e3;

    private Etapa etapa1;
    private Etapa etapa2;

    private ArrayList<Resultado> resultado;

    private Resultado res1, res2;

    /**
     * Default constructor for test class CiclistaExperimentadoTest
     */
    public CiclistaExperimentadoTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        etapa1 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        etapa2 = new Etapa("sencilla larga", Dificultad.SENCILLA, Distancia.LARGA);

        e1 = new Equipo("DSM Women", new ComparatorEnergia(), new ComparatorPeso());
        e2 = new Equipo("Trek Segafredo Women", new ComparatorHabilidad().reversed(), new ComparatorPeso().reversed());
        e3 = new Equipo("Movistar Women", new ComparatorHabilidad(), new ComparatorPeso());

        resultado = new ArrayList<Resultado>();

        c1 = new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, e1);
        c2 = new CiclistaExperimentado("LONGO-BORGHINI", Habilidad.NORMAL, 1175, e2);
        c3 = new CiclistaExperimentado("NORSGAARD", Habilidad.NORMAL, 1145, e3);

        b1 = new BicicletaNormal("SCOTT CONTESSA ADDICT 15", Peso.NORMAL);
        b2 = new BicicletaNormal("TREK Madone SLR 9 eTap Gen 7", Peso.LIGERA);
        b3 = new BicicletaNormal("CANYON Aeroad CF SLX 8 Disc Di2", Peso.NORMAL);

        c1.setBicicleta(b1);
        c2.setBicicleta(b2);
        c3.setBicicleta(b3);
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
    public void PruebaGetDestreza() {
        assertEquals(0.92, c1.Destreza());
        assertEquals(0.77, c2.Destreza());
        assertEquals(0.77, c3.Destreza());
    }

    @Test
    public void PruebaGetTiempoTerminadas() {
        res1 = new Resultado(etapa1, c1.getBicicleta().calcularTiempoNecesario(etapa1, c1), true);
        resultado.add(res1);
        c1.setResultados(resultado);

        res2 = new Resultado(etapa2, c1.getBicicleta().calcularTiempoNecesario(etapa2, c1), true);
        resultado.add(res2);
        c1.setResultados(resultado);

        assertEquals(215.15, c1.getTiempoTerminadas());
    }

    @Test
    public void PruebaGetEtapaAbandonada() {
        res1 = new Resultado(etapa1, c1.getBicicleta().calcularTiempoNecesario(etapa1, c1), true);
        resultado.add(res1);
        c1.setResultados(resultado);

        res2 = new Resultado(etapa2, c1.getBicicleta().calcularTiempoNecesario(etapa2, c1), false);
        resultado.add(res2);
        c1.setResultados(resultado);

        assertEquals(etapa2, c1.getEtapaAbandonada());
    }

    @Test
    public void PruebaGetResultado() {
        res1 = new Resultado(etapa1,c1.getBicicleta().calcularTiempoNecesario(etapa1, c1),true);
        resultado.add(res1);
        c1.setResultados(resultado);

        assertEquals(etapa1, c1.getResultado(etapa1).getEtapa());
    }

    @Test
    public void PruebaGetEtapasTerminadas() {
        res1 = new Resultado(etapa1, c1.getBicicleta().calcularTiempoNecesario(etapa1, c1), true);
        resultado.add(res1);
        c1.setResultados(resultado);

        res2 = new Resultado(etapa2, c1.getBicicleta().calcularTiempoNecesario(etapa2, c1), false);
        resultado.add(res2);
        c1.setResultados(resultado);

        assertEquals(1.0, c1.getEtapasTerminadas());
    }

    @Test
    public void Pruebacorrer() {
        c1.setTiempoEtapa(c1.getBicicleta().calcularTiempoNecesario(etapa1, c1));
        assertEquals(118.52, c1.getBicicleta().calcularVelocidad(c1, etapa1));
        assertEquals(101.25, c1.getTiempoEtapa());

        c2.setTiempoEtapa(c2.getBicicleta().calcularTiempoNecesario(etapa1, c2));
        assertEquals(90.7, c2.getBicicleta().calcularVelocidad(c2, etapa1));
        assertEquals(132.3, c2.getTiempoEtapa());

        c3.setTiempoEtapa(c3.getBicicleta().calcularTiempoNecesario(etapa1, c3));
        assertEquals(118.52, c3.getBicicleta().calcularVelocidad(c1, etapa1));
        assertEquals(135.0, c3.getTiempoEtapa());
    }
}

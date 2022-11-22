

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Grupo de pruebas de la clase Ciclista; en el se realizan todas las pruebas de cada módulo pública
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CiclistaTest {
    private Ciclista ciclista1;
    private Ciclista ciclista2;
    private Bicicleta bicicleta1;
    private Bicicleta bicicleta2;
    private Etapa etapa1;
    private Etapa etapa2;
    private Resultado resultado1;

    private Resultado resultado2;

    private Equipo equipo1;

    private Equipo equipo2;

    /**
     * Default constructor for test class CiclistaTest
     */
    public CiclistaTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        ciclista1 = new Ciclista("David Cortés", 5.0, 1160, equipo1);
        ciclista2 = new Ciclista("Antonio Herrera", 4.97, 1150, equipo2);
        bicicleta1 = new Bicicleta("SCOTT CONTESSA ADDICT 15", 7.6);
        bicicleta2 = new Bicicleta("TREK Emonda SLR 9 eTap", 7.65);
        etapa1 = new Etapa("sencilla larga", 0.9, 200);
        etapa2 = new Etapa("normal larga", 1.0, 200);
        resultado1 = new Resultado(etapa1, 76.0, true);
        resultado2 = new Resultado(etapa2, 80.0, true);
      //  equipo1 = new Equipo("dSMWomen", );
      //  equipo2 = new Equipo("trekSegafredoWomen");
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
    public void pruebaHabilidad() {
        //assertEquals(5.0, ciclista1.getHabilidad());
      //  assertEquals(4.97, ciclista2.getHabilidad());
    }

    @Test
    public void correr() {
        // ciclista1.setBicicleta();
    }
}


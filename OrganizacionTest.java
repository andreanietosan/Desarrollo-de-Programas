

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * The test class OrganizacionTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrganizacionTest {
    private Equipo equipo1;
    private Equipo equipo2;
    private Organizacion organizacion;
    private CiclistaExperimentado c1;
    private CiclistaExperimentado c2;
    private CiclistaEstrella cic1;
    private CiclistaEstrella cic2;
    private BicicletaNormal b1;
    private BicicletaNormal b2;
    private BicicletaNormal b3;
    private BicicletaRapida b4;

    /**
     * Default constructor for test class OrganizacionTest
     */
    public OrganizacionTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        organizacion = new Organizacion(new ComparadorDificultadEtapa());

        equipo1 = new Equipo("Movistar Women", new ComparatorHabilidad(), new ComparatorPeso());
        equipo2 = new Equipo("DSM Women", new ComparatorEnergia(), new ComparatorPeso());

        organizacion.inscribirEquipo(equipo1);
        organizacion.inscribirEquipo(equipo2);

        c1 = new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, equipo1);
        c2 = new CiclistaExperimentado("LONGO-BORGHINI", Habilidad.NORMAL, 1175, equipo1);

        cic1 = new CiclistaEstrella("LIPPERT", Habilidad.NORMAL, 1160, equipo2);
        cic2 = new CiclistaEstrella("BALSAMO", Habilidad.NORMAL, 1180, equipo2);

        b1 = new BicicletaNormal("SCOTT CONTESSA ADDICT 15", Peso.NORMAL);
        b2 = new BicicletaNormal("TREK Madone SLR 9 eTap Gen 7", Peso.LIGERA);
        b3 = new BicicletaNormal("CANYON Aeroad CF SLX 8 Disc Di2", Peso.NORMAL);
        b4 = new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15", Peso.LIGERA, 0.3);

        equipo1.anadirCiclista(c1);
        equipo1.anadirCiclista(c2);
        equipo1.anadirBicicleta(b1);
        equipo1.anadirBicicleta(b2);

        equipo2.anadirCiclista(cic1);
        equipo2.anadirCiclista(cic2);
        equipo2.anadirBicicleta(b3);
        equipo2.anadirBicicleta(b4);
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
    public void PruebaInscribirEquipo() {
        organizacion.inscribirEquipo(equipo1);
        organizacion.inscribirEquipo(equipo2);

        assertEquals("Movistar Women", organizacion.getEquipos().get(0).getNombreEquipo());
        assertEquals("DSM Women", organizacion.getEquipos().get(1).getNombreEquipo());
    }

    @Test
    public void PruebaRecibir() {
        ArrayList<Ciclista> aux = new ArrayList<>();
        organizacion.recibir();

        Iterator it = organizacion.getCiclCarrera().entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry datos = (Map.Entry) it.next(); //dato contiene la entrada del haspmap // key(ciclista) valor(equipo)
            Ciclista ciclista = (Ciclista) datos.getKey(); //la entrada se ha declarado con este nombre (datos.getkey)
            aux.add(ciclista);
        }
        assertEquals("LABOUS", aux.get(0).getNombreCiclista());
        assertEquals("BALSAMO", aux.get(1).getNombreCiclista());
        assertEquals("LONGO-BORGHINI", aux.get(2).getNombreCiclista());
        assertEquals("LIPPERT", aux.get(3).getNombreCiclista());
    }
}

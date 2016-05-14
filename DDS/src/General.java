import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;


public class General {

	private Comuna comuna5;
	private Comuna comuna14;
	private Interface sistema;
	private Rubro banco;
	private Comercio cafeteria;
	private Parada paradaColectivo;
	private CGP cgp;
	private Poi parada160;
	private Poi starbucks;
	private Poi hsbc;
	private Poi medrano;

	
	/*
	 * Corro este codigo para todos los test
	 */
	@Before
	public void setUp() {
		/*
		 * Creo las comunas
		 */
		comuna5 = new Comuna();
		comuna5.setNombre("Almagro");
		
		comuna14 = new Comuna();
		comuna14.setNombre("Palermo");
		
		/*
		 * Creo la interface
		 */
		sistema = new Interface();
		sistema.setGeolocalizar(-34.59782973357171, -58.42024974524975);
		sistema.setComuna(comuna5);
		
		/*
		 * Creo los rubros de los POIs
		 */
		banco = new Rubro();
		banco.setNombre("Banco");
		
		cafeteria = new Comercio();
		cafeteria.setNombre("Cafeteria");
		cafeteria.setRadioCercania(400);
		
		paradaColectivo = new Parada();
		paradaColectivo.setNombre("Parada de Colectivo");
		
		cgp = new CGP();
		cgp.setNombre("Centro de Gestion y Participacion");
		
		/*
		 * Creo POIs de ejemplo
		 */
		parada160 = new Poi();
		parada160.setNombre("Parada 160");
		parada160.setGeolocalizar(-34.59767959749551, -58.420222252607346);
		parada160.setQueSoy(paradaColectivo);
		parada160.setComuna(comuna14);
		parada160.setTags("colectivo,160,parada");
		
		starbucks = new Poi();
		starbucks.setNombre("StarBucks");
		starbucks.setGeolocalizar(-34.58986883545346, -58.425733521580696);
		starbucks.setQueSoy(cafeteria);
		starbucks.setComuna(comuna14);
		
		hsbc = new Poi();
		hsbc.setNombre("HSBC");
		hsbc.setGeolocalizar(-34.589780511683834, -58.42567451298237);
		hsbc.setQueSoy(banco);
		hsbc.setComuna(comuna14);
		
		medrano = new Poi();
		medrano.setGeolocalizar(-34.598593, -58.419936);
		medrano.setNombre("UTN Medrano");
		medrano.setQueSoy(cgp);
		medrano.setComuna(comuna5);
		
		// Agrego los POIs al sistema
		sistema.addPoi(parada160);
		sistema.addPoi(starbucks);
		sistema.addPoi(hsbc);
		sistema.addPoi(medrano);		
		sistema.poisCercanos();
	}
	/*
	 * ENREGA 1
	 */
	
	@Test
	public void testPoisCercanos(){			
		// Tiene que devolver solo "medrano" y "parada160"		
		
		assertEquals(2, sistema.poisCercanos().size());
		assertTrue(sistema.poisCercanos().contains(medrano));
		assertTrue(sistema.poisCercanos().contains(parada160));
	}
	
	@Test
	public void testBuscarPois(){			
		// Busco: parada
		assertEquals(1, sistema.buscarPois("parada").size());
		assertTrue(sistema.buscarPois("parada").contains(parada160));
		
		// Busco: cafe
		assertEquals(1, sistema.buscarPois("cafe").size());
		assertTrue(sistema.buscarPois("cafe").contains(starbucks));
		
		// Busco: UTN HSBC
		assertEquals(2, sistema.buscarPois("UTN HSBC").size());
		assertTrue(sistema.buscarPois("UTN HSBC").contains(medrano));
		assertTrue(sistema.buscarPois("UTN HSBC").contains(hsbc));
	}
	
	/*
	 * ENTEGA 0B
	 */
	@Test
	public void testEsPoiValido(){
		Poi poi1 = new Poi();
		poi1.setGeolocalizar(-34.598593, -58.419936);
		poi1.setNombre("medrano");
		assertTrue(poi1.esValido());
		Poi poi2 = new Poi();
		assertFalse(poi2.esValido());
	}
	
	@Test
	public void testCercaniaEntreDosPois(){
		Poi medrano = new Poi();
		medrano.setGeolocalizar(-34.598593, -58.419936);
		medrano.setNombre("Medrano");

		Poi obelisco = new Poi();
		obelisco.setGeolocalizar(-34.6037389, -58.38157039999999);
		obelisco.setNombre("Obelisco");
		
		//System.out.println("Sale "+medrano.distanciaAlPoi(obelisco));
		
		// La distancia al obelisco desde Medrano es de 3,5KM aproximadamente
		assertTrue(medrano.dentroRadio_POI(obelisco, 3600));
	}

}
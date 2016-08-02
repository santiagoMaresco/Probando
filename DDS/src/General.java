import org.junit.*;
import static org.junit.Assert.*;

import java.util.Collection;

public class General {

	private Comuna comuna5;
	private Comuna comuna14;
	private Terminal sistema;
	private Mapa mapa;
	private Parada parada160;
	private Comercio starbucks;
	private Banco hsbc;
	private CGP medrano;

	private RangoServicioDTO rangoLunes;
	private RangoServicioDTO rangoMartes;
	private RangoServicioDTO rangoMiercoles;
	private RangoServicioDTO rangoJueves;
	private RangoServicioDTO rangoViernes;
	private ServicioDTO servicioAyudaSocial;
	private ServicioDTO servicioDocumentacion;
	private CentroDTO cgp1;
	private CentroDTO cgp2;
	private ObtenerCentroDTO unCentroDTO;
	
	private Administrador admin;
	private Ejecutor control;
	private ProcesoActualizaciónComercios metodo1;
	private ProcesoBajaPOI metodo2;
	private ProcesoAgregarAccionesUsuarios metodo3;
	private ProcesoEjecutarProcesosMultiples metodo4;
	

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

		mapa = new Mapa();
		/*
		 * Creo la interface
		 */
		sistema = new Terminal();
		sistema.setGeolocalizar(-34.59782973357171, -58.42024974524975);
		sistema.setComuna(comuna5);
		sistema.setMapa(mapa);

		/*
		 * Creo POIs de ejemplo
		 */
		parada160 = new Parada();
		parada160.setNombre("Parada 160");
		parada160.setQueSoy("Parada");
		parada160.setGeolocalizar(-34.59767959749551, -58.420222252607346);
		parada160.setComuna(comuna14);
		parada160.setTags("colectivo,160,parada");

		starbucks = new Comercio();
		starbucks.setNombre("StarBucks");
		starbucks.setGeolocalizar(-34.58986883545346, -58.425733521580696);
		starbucks.setRadioCercania(400);
		starbucks.setQueSoy("Cafeteria");
		starbucks.setComuna(comuna14);

		hsbc = new Banco();
		hsbc.setNombre("HSBC");
		hsbc.setGeolocalizar(-34.589780511683834, -58.42567451298237);
		hsbc.setQueSoy("Banco");
		hsbc.setComuna(comuna14);

		medrano = new CGP();
		medrano.setGeolocalizar(-34.598593, -58.419936);
		medrano.setNombre("UTN Medrano");
		medrano.setQueSoy("CGP");
		medrano.setComuna(comuna5);

		// Agrego los POIs al sistema

		sistema.getMapa().addPoi(parada160);
		sistema.getMapa().addPoi(starbucks);
		sistema.getMapa().addPoi(hsbc);
		sistema.getMapa().addPoi(medrano);

		// Agrego CentrosDTO

		rangoLunes = new RangoServicioDTO(1, 9, 0, 18, 0);
		rangoMartes = new RangoServicioDTO(2, 9, 0, 18, 0);
		rangoMiercoles = new RangoServicioDTO(3, 9, 0, 18, 0);
		rangoJueves = new RangoServicioDTO(4, 9, 0, 18, 0);
		rangoViernes = new RangoServicioDTO(5, 9, 0, 18, 0);
		servicioAyudaSocial = new ServicioDTO();
		servicioDocumentacion = new ServicioDTO();
		cgp1 = new CentroDTO();
		cgp2 = new CentroDTO();
		unCentroDTO = new ObtenerCentroDTOPrecargado();

		// Set un servicio
		servicioAyudaSocial.setNombre("Ayuda Social");
		servicioAyudaSocial.rangosServicioDTO.add(rangoLunes);
		servicioAyudaSocial.rangosServicioDTO.add(rangoMartes);
		servicioAyudaSocial.rangosServicioDTO.add(rangoMiercoles);
		servicioAyudaSocial.rangosServicioDTO.add(rangoJueves);
		servicioAyudaSocial.rangosServicioDTO.add(rangoViernes);
		// Set el cgp1
		cgp1.setNroComuna(7);
		cgp1.setZonas("Almagro");
		cgp1.setNombreDirector("Gustavo Fernandez");
		cgp1.setDomicilioCompleto("Medrano 900");
		cgp1.setTelefono("49254787");
		cgp1.serviciosDTO.add(servicioAyudaSocial);

		// Set un servicio
		servicioDocumentacion.setNombre("Documentacion");
		servicioDocumentacion.rangosServicioDTO.add(rangoLunes);
		servicioDocumentacion.rangosServicioDTO.add(rangoLunes);
		servicioDocumentacion.rangosServicioDTO.add(rangoLunes);
		servicioDocumentacion.rangosServicioDTO.add(rangoLunes);
		servicioDocumentacion.rangosServicioDTO.add(rangoLunes);
		// Set el cgp2
		cgp2.setNroComuna(15);
		cgp2.setZonas("Palermo");
		cgp2.setNombreDirector("Federico Fernandez");
		cgp2.setDomicilioCompleto("Scalabrini Ortiz 500");
		cgp2.setTelefono("49254788");
		cgp2.serviciosDTO.add(servicioAyudaSocial);
		unCentroDTO.listaCGPs.add(cgp1);
		unCentroDTO.listaCGPs.add(cgp2);
		
		//Set Administrador, Ejecutor y metodo1
		control = new Ejecutor();
		
		admin = new Administrador();
		admin.setControl(control);
		admin.setMapa(mapa);
		
		metodo1 = new ProcesoActualizaciónComercios();
		metodo1.setAdmin(admin);
		
	}

	/*
	 * ENTREGA 4
	 */
	
	@Test
	public void testProcesoActualizacionComercios() {
		admin.control.setProceso(metodo1);
		admin.control.iniciarProceso();
		assertEquals(1, metodo1.resultados.size());
	}
	
	/*
	 * ENTREGA 2
	 */

	@Test
	public void buscarBancoJson() {
		Collection<Poi> poi_tmp = mapa.buscarBanco("banco", "deposito");
		assertEquals(2, poi_tmp.size());
	}

	@Test
	public void testBuscarCGP() {
		assertEquals(1, unCentroDTO.obtenerCentrosDTO("Almagro").size());
		assertEquals(1, unCentroDTO.obtenerCentrosDTO("Scalabrini Ortiz 500").size());
	}

	/*
	 * ENTREGA 1
	 */

	@Test
	public void testPoisCercanos() {
		// Tiene que devolver solo "medrano" y "parada160"

		assertEquals(2, sistema.poisCercanos().size());
		assertTrue(sistema.poisCercanos().contains(medrano));
		assertTrue(sistema.poisCercanos().contains(parada160));
	}

	@Test
	public void testFechaActual(){
		assertEquals("1/8/2016",mapa.fechaActual());
	}
	@Test
	public void testDisponibilidad() {
		DisponibilidadHoraria hora_starbucks_lunes = new DisponibilidadHoraria();
		hora_starbucks_lunes.setHorario(1, "20:00", "23:00", null);

		DisponibilidadHoraria hora_starbucks_martes = new DisponibilidadHoraria();
		hora_starbucks_martes.setHorario(2, "20:00", "23:00", null);

		DisponibilidadHoraria hora_medrano_firma_libreta = new DisponibilidadHoraria();
		hora_medrano_firma_libreta.setHorario(1, "20:00", "23:00", "Firmar Libreta");

		DisponibilidadHoraria hora_medrano_firma_libreta2 = new DisponibilidadHoraria();
		hora_medrano_firma_libreta2.setHorario(4, "20:00", "23:00", "Firmar Libreta");

		DisponibilidadHoraria hora_medrano_cursada = new DisponibilidadHoraria();
		hora_medrano_cursada.setHorario(1, "20:00", "23:00", "Cursada");

		//
		starbucks.addHorario(hora_starbucks_lunes);
		starbucks.addHorario(hora_starbucks_martes);
		assertTrue(starbucks.estoyDisponibleEl(2, "22:00"));
		//

		medrano.addHorario(hora_medrano_firma_libreta);
		medrano.addHorario(hora_medrano_firma_libreta2);
		medrano.addHorario(hora_medrano_cursada);

		assertTrue(medrano.estoyDisponibleEl(1, "22:00", "Firmar Libreta"));
		assertTrue(medrano.estoyDisponibleEl(4, "22:00", null));
		assertTrue(medrano.estoyDisponibleEl(1, "22:00", "Cursada"));

	}

	@Test
	public void testBuscarPois() {
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
	public void testEsPoiValido() {
		Poi poi1 = new Poi();
		poi1.setGeolocalizar(-34.598593, -58.419936);
		poi1.setNombre("medrano");
		assertTrue(poi1.esValido());
		Poi poi2 = new Poi();
		assertFalse(poi2.esValido());
	}

	@Test
	public void testCercaniaEntreDosPois() {
		Poi medrano = new Poi();
		medrano.setGeolocalizar(-34.598593, -58.419936);
		medrano.setNombre("Medrano");

		Poi obelisco = new Poi();
		obelisco.setGeolocalizar(-34.6037389, -58.38157039999999);
		obelisco.setNombre("Obelisco");

		// System.out.println("Sale "+medrano.distanciaAlPoi(obelisco));

		// La distancia al obelisco desde Medrano es de 3,5KM aproximadamente
		assertTrue(medrano.dentroRadio_POI(obelisco, 3600));
	}

}
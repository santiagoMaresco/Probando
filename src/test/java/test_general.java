import static org.junit.Assert.*;

import org.junit.Test;

public class General {

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
	public void testPoiCercano(){
		Poi medrano = new Poi();
		medrano.setGeolocalizar(-34.598593, -58.419936);
		medrano.setNombre("Medrano");

		Poi obelisco = new Poi();
		obelisco.setGeolocalizar(-34.6037389, -58.38157039999999);
		obelisco.setNombre("Obelisco");
		
		//System.out.println("Sale "+medrano.distanciaA(obelisco));
		
		// La distancia al obelisco desde Medrano es de 3,5KM aproximadamente
		assertTrue(medrano.dentroRadio(obelisco, 3600));
	}

}

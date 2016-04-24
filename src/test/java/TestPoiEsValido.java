import org.junit.Test;

import junit.framework.Assert;


public class TestPoiEsValido {
	@Test
	public void unPoiEsValido(){
		Poi unPoi = new Poi();
		unPoi.setGeolocalizar(-34.598593, -58.419936);
		unPoi.setNombre("medrano");
		boolean esValido = unPoi.esValido();
		Assert.assertTrue(esValido);
	}
}

public class Comercio extends Poi {
	public double radioCercania;
	
	/*
	 * SETs y GETs
	 */
	
	public void setRadioCercania(double unRadio) {
		this.radioCercania = unRadio;
	}
	
	/*
	 * compararCercania();
	 * Detalle: Dado un POI y una Interface, te decie si esta cerca o no.
	 * 
	 */
	
	public boolean compararCercania(Poi unPoi, double latitudDeTerminal,double longitudDeTerminal,String comuna) {
		if(unPoi.dentroDelRadio(latitudDeTerminal, longitudDeTerminal, this.radioCercania)){
			return true;
		}
		return false;
	}
}
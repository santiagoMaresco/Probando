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
	public boolean compararCercania(Poi unPoi, Interface unaInterface) {
		if(unPoi.dentroDelRadio(unaInterface.latitud, unaInterface.longitud, this.radioCercania)){
			return true;
		}
		return false;
	}
}
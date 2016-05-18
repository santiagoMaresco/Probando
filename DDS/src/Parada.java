public class Parada extends Poi {
	
	/*
	 * compararCercania();
	 * Detalle: Dado un POI y una Interface, te decie si esta cerca o no.
	 * 
	 */
	public boolean compararCercania(Poi unPoi, Interface unaInterface) {
		if(unPoi.dentroDelRadio(unaInterface.latitud, unaInterface.longitud, 100)){
			return true;
		}
		return false;
	}
	
	public boolean estoyDisponibleEl(int unDia, String unaHora){
		return true;
	}
	
}
public class Parada extends Poi {
	
	/*
	 * compararCercania();
	 * Detalle: Dado un POI y una Interface, te decie si esta cerca o no.
	 * 
	 */
	@Override
	public boolean compararCercania(Poi unPoi, double latitudDeTerminal, double longitudDeTerminal, String comunaDeTerminal) {
		if(unPoi.dentroDelRadio(latitudDeTerminal, longitudDeTerminal, 100)){
			return true;
		}
		return false;
	}
	
	public boolean estoyDisponibleEl(int unDia, String unaHora){
		return true;
	}
	
}

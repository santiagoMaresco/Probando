
public class CGP extends Rubro {
	/*
	 * compararCercania();
	 * Detalle: Dado un POI y una Interface, te decie si esta cerca o no.
	 * 
	 */
	public boolean compararCercania(Poi unPoi, Interface unaInterface) {
		if(unPoi.comuna == unaInterface.comuna){
			return true;
		}
		return false;
	}
}

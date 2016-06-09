
public class Rubro{
	public String nombre;
	
	/*
	 * SETs y GETs
	 */
	
	public void setNombre(String nom) {
		this.nombre = nom;
	}
	
	/*
	 * compararCercania();
	 * Detalle: Dado un POI y una Interface, te decie si esta cerca o no.
	 * 
	 */

	public boolean compararCercania(Poi unPoi, double latitudDeTerminal, double longitudDeTerminal, String comunaTerminal) {
		if(unPoi.dentroDelRadio(latitudDeTerminal, longitudDeTerminal, 500)){
			return true;
		}
		return false;
	}
	
	/*
	 * pesoBusqueda();
	 * Detalle: Dada una palabra, devuelvo el peso de dicha palabra que tiene con el RUBRO.
	 */
	
	public int pesoBusqueda(String palabra) {
		int pesoPalabra = 0;
		// Busco en el nombre del POI
		if(this.nombre.toLowerCase().contains(palabra.toLowerCase())){
			pesoPalabra+= 1;
		}
		//
		return pesoPalabra;
	}
}

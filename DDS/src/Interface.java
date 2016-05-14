import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Interface {
	public double latitud;
	public double longitud;
	public Comuna comuna;
	Collection<Poi> pois = new HashSet<Poi>();
	
	/*
	 * INITIALIZE
	 */
	
	public Interface(){
		this.latitud = 0;
		this.longitud = 0;
	}
	
	/*
	 * SETs y GETs
	 */
	public void setComuna(Comuna unaComuna) {
		this.comuna = unaComuna;
	}
	
	public void setGeolocalizar(double unaLati, double unaLongi) {
		this.latitud = unaLati;
		this.longitud = unaLongi;
	}
	
	/*
	 * addPoi();
	 * Detalle: Agrega un POI a la coleccion
	 */
	public void addPoi(Poi unPoi){
		pois.add(unPoi);
	}
	
	/*
	 * delPoi();
	 * Detalle: Elimina un POI a la coleccion
	 */
	public void delPoi(Poi unPoi){
		pois.remove(unPoi);
	}
	
	/*
	 * poisCercanos();
	 * Detalle: Busca los pois cercanos al terminal, segun el criterio de cercania de cada poi.
	 */
	public Collection<Poi> poisCercanos(){
		Collection<Poi> pois_tmp = new HashSet<Poi>();
		Iterator<Poi> it = (this.pois).iterator();
		while(it.hasNext())
		{
			Poi i = it.next();
			if(i.estoyCercaDeLaInterface(this)) pois_tmp.add(i);
		}
		return pois_tmp;
	}	
	
	/*
	 * buscarPois();
	 * Detalle: Busca segun texto libre
	 */
	public Collection<Poi> buscarPois(String texto){
		// Creo un array de palabras
		String[] palabras = texto.split(" ");
		int pesoBusqueda;
		Collection<Poi> pois_tmp = new HashSet<Poi>();
		Iterator<Poi> it = (this.pois).iterator();
		while(it.hasNext())
		{
			Poi i = it.next();
			
			pesoBusqueda = 0;
			if(palabras != null){
				// Busco cada palabra ingresada
				for(String palabra:palabras){
					pesoBusqueda += i.pesoBusqueda(palabra);
				}
			}
			if(pesoBusqueda > 0) pois_tmp.add(i);
		}
		return pois_tmp;
	}
}

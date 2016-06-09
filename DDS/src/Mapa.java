import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Mapa {

	public Collection<Poi> pois = new HashSet<Poi>();
	
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
	public Collection<Poi> poisCercanos(double latitud,double longitud,String comuna){
		Collection<Poi> pois_tmp = new HashSet<Poi>();
		Iterator<Poi> it = (this.pois).iterator();
		while(it.hasNext())
		{
			Poi unPoi = it.next();
			if(unPoi.estoyCercaDeLaTerminal(latitud,longitud,comuna))
				pois_tmp.add(unPoi);
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

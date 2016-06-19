import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.*;
import org.json.JSONException;
import org.json.JSONObject;



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
	 * contPoi();
	 * Detalle: Devuelve true si el POI está en la colección
	 */
	
	public boolean contPoi(Poi unPoi){
		if(pois.contains(unPoi)){
			return true;
		}
		else{
			return false;
		}
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
	
	public String httpGetSimple(String url){
	    String source = null;
	 
	    HttpClient httpClient = HttpClients.createDefault();
	    HttpGet httpGet = new HttpGet(url);
	    try {
	    	HttpResponse httpResponse = httpClient.execute(httpGet);
	        source = EntityUtils.toString(httpResponse.getEntity());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return source;
	}
	
	/*
	 * buscarBanco(String nombre, String servicio)
	 * Detalle: Dado un nombre de un banco, y un servicio, hace una peticion HTTP para obtener los bancos que satisfacen esa busqueda
	 */
	public Collection<Poi> buscarBanco(String nombre, String servicio) {
		Poi unPoi;
		Collection<Poi> pois_tmp = new HashSet<Poi>();
		// Falta URLENCODE a nombre y servicio
		String urlServer = "http://marcobiondi.com.ar/banks.html?banco="+(nombre)+"&servicio="+(servicio);
		String htmlSource = this.httpGetSimple(urlServer);
		//
		try {
			JSONArray jsonArray = new JSONArray(htmlSource);
			int count = jsonArray.length();
			//
			for(int i=0 ; i< count; i++){
				unPoi = new Poi();
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				unPoi.setQueSoy("Banco");
				unPoi.setNombre(jsonObject.getString("banco"));
				unPoi.setGeolocalizar(jsonObject.getDouble("x"), jsonObject.getDouble("y"));				
				// Agrego el Poi en el resultado
				pois_tmp.add(unPoi);
			}		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		return pois_tmp;
		
	}


}

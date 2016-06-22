
public class Administrador {

	public Mapa unMapa; 
	
	/* Alta baja y modificación de POIs */
	
	/*Alta */
	
	public void agregarUnPoi (Poi unPoi){
		this.unMapa.addPoi(unPoi);
	}
	
	/* Modificacion */ 
		
	public void modificarNombre(Poi unPoi, String nuevoNombre){
		if(unMapa.contPoi(unPoi)){
			unPoi.setNombre(nuevoNombre);
		}
		else{
			System.out.println(unPoi.nombre + "no se haya dentro del mapa");
		}
	}
	
	public void modificarRubro(Poi unPoi, String rubro){
		if(unMapa.contPoi(unPoi)){
			unPoi.setQueSoy(rubro);
		}
		else{
			System.out.println(unPoi.nombre + "no se haya dentro del mapa");
		}
	}
	
	public void modificarComuna(Poi unPoi, Comuna unaComuna){
		if(unMapa.contPoi(unPoi)){
			unPoi.setComuna(unaComuna);
		}	
		else{
			System.out.println(unPoi.nombre + "no se haya dentro del mapa");
		}
	}
	
	public void modificarTags(Poi unPoi, String tags){
		if(unMapa.contPoi(unPoi)){
			unPoi.setTags(tags);
		}
		else{
			System.out.println(unPoi.nombre + "no se haya dentro del mapa");
		}
	}
	
	public void modificarGeolocalizacion(Poi unPoi, double unaLati, double unaLongi){
		if(unMapa.contPoi(unPoi)){
			unPoi.setGeolocalizar(unaLati, unaLongi);
		}
		else{
			System.out.println(unPoi.nombre + "no se haya dentro del mapa");
		}
	}
	
	/* Baja */
	
	public void eliminarUnPoi (Poi unPoi){
		this.unMapa.delPoi(unPoi);
	}
	
}

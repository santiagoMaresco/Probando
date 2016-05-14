public class Poi {
	public double latitud;
	public double longitud;
	public String nombre;
	public Rubro queSoy;
	public Comuna comuna;
	public String[] tags;
	
	/*
	 * INITIALIZE
	 */
	
	public Poi(){
		this.latitud = 0;
		this.longitud = 0;
		this.nombre = null;
		this.queSoy = null;
	}
	
	/*
	 * SETs y GETs
	 */
	
	public void setNombre(String nom) {
		this.nombre = nom;
	}
	
	public void setQueSoy(Rubro unRubro) {
		this.queSoy = unRubro;
	}
	
	public void setComuna(Comuna unaComuna) {
		this.comuna = unaComuna;
	}
	
	public void setTags(String texto) {
		this.tags = texto.split(",");
	}
	
	public void setGeolocalizar(double unaLati, double unaLongi) {
		this.latitud = unaLati;
		this.longitud = unaLongi;
	}
	
	/*
	 * toRad();
	 * Detalle: Convierto a radianes
	 */
	private double toRad(double value) {
	    return value * Math.PI / 180;
	}
	
	/*
	 * distanciaA();
	 * Detalle: Dado una latitud y longitud, devuelve la distancia desde el POI hasta dicho punto. En mentros
	 */
	public double distanciaA(double latitud, double longitud){
		double radio_tierra = 6371000; // En metros
		double diferencia_longitud = toRad(longitud - this.longitud);
		double diferencia_latitud = toRad(latitud - this.latitud);
		
		// Formula matematica
		double a = Math.sin(diferencia_latitud/2) * Math.sin(diferencia_latitud/2) + Math.cos(toRad(this.latitud)) * Math.cos(toRad(latitud)) * Math.sin(diferencia_longitud/2) * Math.sin(diferencia_longitud/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = radio_tierra * c;
		//
		return d;
	}
	
	/*
	 * dentroRadio_POI();
	 * Detalle: Dado un POI y un radio en metros, compara si la distancia entre SELF y el POI es menor al radio
	 */
	public boolean dentroRadio_POI(Poi unPoi, double radio){
		if(dentroDelRadio(unPoi.latitud, unPoi.longitud,radio)){
			return true;
		}
		return false;
	}
	
	
	/*
	 * esValido();
	 * Detalle: Corrobora que tenga latitud, longitud y nombre
	 */
	public boolean esValido() {
		if(this.latitud == 0 || this.longitud == 0 || this.nombre == null) return false;
		return true;
	}
	
	/*
	 * estoyCercaDeLaInterface();
	 * Detalle: dada una interface, devuelve true si estoy cerca de ella.
	 */
	
	public boolean estoyCercaDeLaInterface(Interface unaInterface){
		if(queSoy.compararCercania(this, unaInterface)){
			return true;
		}
		return false;
	}

	/*
	 * dentroDelRadio();
	 * Detalle: Dado una latitud y longitud, y un radio en metros, compara si la distancia entre SELF y el punto es menor al radio
	 */
	
	public boolean dentroDelRadio(double latitud, double longitud, double radio) {
		if(distanciaA(latitud, longitud) <= radio) return true;
		return false;
	}
	
	/*
	 * pesoBusqueda();
	 * Detalle: Dada una palabra, devuelvo el peso de dicha palabra que tiene con el POI.
	 */
	
	public int pesoBusqueda(String palabra) {
		int pesoPalabra = 0;
		// Busco en el nombre del POI
		if(this.nombre.toLowerCase().contains(palabra.toLowerCase())){
			pesoPalabra+= 1;
		}
		// Busco en los tags del POI
		if(this.tags != null){
			for(String tag:this.tags){
				if(tag.toLowerCase().contains(palabra.toLowerCase())){
					pesoPalabra+= 1;
				}
			}
		}
		// Busco en rubro
		pesoPalabra += this.queSoy.pesoBusqueda(palabra);		
		//
		return pesoPalabra;
	}
	
}
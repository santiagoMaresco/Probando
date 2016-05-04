public class Poi {
	public double latitud;
	public double longitud;
	public String nombre;
	public String queSoy;
	
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
	 * Detalle: Devuelve la distancia que hay hasta unPoi, en metros.
	 */
	public double distanciaA(Poi unPoi){
		double radio_tierra = 6371000; // En metros
		double diferencia_longitud = toRad(unPoi.longitud - this.longitud);
		double diferencia_latitud = toRad(unPoi.latitud - this.latitud);
		
		// Formula matematica
		double a = Math.sin(diferencia_latitud/2) * Math.sin(diferencia_latitud/2) + Math.cos(toRad(this.latitud)) * Math.cos(toRad(unPoi.latitud)) * Math.sin(diferencia_longitud/2) * Math.sin(diferencia_longitud/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = radio_tierra * c;
		//
		return d;
	}
	/*
	 * dentroRadio();
	 * Detalle: Compara la distancia entre los POI, contra un radio en metros.
	 */
	public boolean dentroRadio(Poi unPoi, double radio){
		if(distanciaA(unPoi) > radio) return false;
		return true;
	}
	
	
	/*
	 * esValido();
	 * Detalle: Debe tener latitud, longitud y nombre
	 */
	public boolean esValido() {
		if(this.latitud == 0 || this.longitud == 0 || this.nombre == null) return false;
		return true;
	}
	
}

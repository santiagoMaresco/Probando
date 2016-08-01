import java.util.Collection;

public class Terminal extends Usuario {
	public String nombre; //Agregar nombre al test!! no olvidar!!
	public double latitud;
	public double longitud;
	public Comuna comuna;
	
	
	/*
	 * INITIALIZE
	 */
	
	public Terminal(){
		this.latitud = 0;
		this.longitud = 0;
	}

	
	
	/*
	 * SETs y GETs
	 */
	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}
	public void setComuna(Comuna unaComuna) {
		this.comuna = unaComuna;
	}
	
	public void setGeolocalizar(double unaLati, double unaLongi) {
		this.latitud = unaLati;
		this.longitud = unaLongi;
	}
	
	public void setMapa(Mapa mapa){
		this.unMapa = mapa;
	}
	
	public Mapa getMapa(){
		return unMapa;
	}
	public Collection<Poi> poisCercanos(){
		return unMapa.poisCercanos(latitud,longitud,comuna.nombre);
	}
	public Collection<Poi> buscarPois(String texto){
		return unMapa.buscarPois(texto,nombre);
	}
	
	
}
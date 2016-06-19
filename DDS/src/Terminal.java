import java.util.Collection;

public class Terminal {
	public double latitud;
	public double longitud;
	public Comuna comuna;
	public Mapa mapa;
	
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
	public void setComuna(Comuna unaComuna) {
		this.comuna = unaComuna;
	}
	
	public void setGeolocalizar(double unaLati, double unaLongi) {
		this.latitud = unaLati;
		this.longitud = unaLongi;
	}
	
	public void setMapa(Mapa mapa){
		this.mapa = mapa;
	}
	
	public Mapa getMapa(){
		return mapa;
	}
	public Collection<Poi> poisCercanos(){
		return mapa.poisCercanos(latitud,longitud,comuna.nombre);
	}
	public Collection<Poi> buscarPois(String texto){
		return mapa.buscarPois(texto);
	}
	
	
}
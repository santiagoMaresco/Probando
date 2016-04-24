
public class Poi {
	private double latitud;
	private double longitud;
	private String nombre;
	private String queSoy;
	
	public void setGeolocalizar(double unaLati, double unaLongi) {
		this.latitud = unaLati;
		this.longitud = unaLongi;
	}

	public boolean esValido() {
		if(this.latitud == 0 || this.longitud == 0){
			return false;
		}else{
		
		return true;
		}
		}

	public void setNombre(String nom) {
		this.nombre = nom;
	}

}

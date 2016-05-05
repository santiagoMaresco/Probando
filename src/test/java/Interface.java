public class Interface {
	public double latitud;
	public double longitud;
	
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
	
	public void setGeolocalizar(double unaLati, double unaLongi) {
		this.latitud = unaLati;
		this.longitud = unaLongi;
	}
}

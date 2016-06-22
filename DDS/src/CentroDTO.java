import java.util.ArrayList;

public class CentroDTO {
	public int nroComuna; // número de la comuna (ej: 3)
	public String zonas; // zonas que incluye (ej. “Balvanera, San Cristóbal” para la comuna 3)
	public String nombreDirector; // nombre del director
	public String domicilioCompleto; // domicilio completo del CGP (ej: Junín 521)
	public String telefono; // teléfono del CGP (4375-0644/45)
	public ArrayList<ServicioDTO> serviciosDTO = new ArrayList<ServicioDTO>(); // lista de “serviciosDTO”: array de servicios
	
// Getters
	
	public int getNroComuna() {
		return nroComuna;
	}
	
	public String getZonas() {
		return zonas;
	}
	
	public String getNombreDirector() {
		return nombreDirector;
	}
	
	public String getDomicilioCompleto() {
		return domicilioCompleto;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public ArrayList<ServicioDTO> getServiciosDTO() {
		return serviciosDTO;
	}


// Setters
	
	public void setNroComuna(int nroComuna) {
		this.nroComuna = nroComuna;
	}
	
	public void setZonas(String zonas) {
		this.zonas = zonas;
	}
	
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
	
	public void setDomicilioCompleto(String domicilioCompleto) {
		this.domicilioCompleto = domicilioCompleto;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setServiciosDTO(ArrayList<ServicioDTO> serviciosDTO) {
		this.serviciosDTO = serviciosDTO;
	}
}
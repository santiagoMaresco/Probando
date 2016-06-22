import java.util.ArrayList;

public class ServicioDTO {
	String nombre; // nombre del servicio (ej: Atención ciudadana)
	ArrayList<RangoServicioDTO> rangosServicioDTO = new ArrayList<RangoServicioDTO>(); // lista de “rangos servicio DTO”: Array con días de servicio

	// Getters
	public String getNombre() {
		return nombre;
	}

	public ArrayList<RangoServicioDTO> getRangosServicioDTO() {
		return rangosServicioDTO;
	}

	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRangosServicioDTO(ArrayList<RangoServicioDTO> rangosServicioDTO) {
		this.rangosServicioDTO = rangosServicioDTO;
	}
}
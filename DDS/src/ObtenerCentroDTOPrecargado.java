import java.util.List;

public class ObtenerCentroDTOPrecargado extends ObtenerCentroDTO {

	// TODO: Definir Constructor con datos de prueba

	public List<CentroDTO> obtenerCentrosDTO(String calleOZona) {
		/*El servicio acepta como parámetro un string que puede corresponder a la calle
		 *  o zona, y devuelve la lista de CGPs disponibles*/
		
		// TODO: Definir comportamiento tipo mock hasta que se habilite el servicio externo
		return listaCGPs;
	}
}
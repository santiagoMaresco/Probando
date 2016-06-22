import java.util.ArrayList;

public class ObtenerCentroDTOServicio extends ObtenerCentroDTO {

	// TODO: Definir Constructor con datos de prueba

	public ArrayList<CentroDTO> obtenerCentrosDTO(String calleOZona) {
		/*El servicio acepta como parámetro un string que puede corresponder a la calle
		 *  o zona, y devuelve la lista de CGPs disponibles*/
		
		// TODO: Definir comportamiento una vez que este habilitado servicio externo
		return listaCGPs;
	}
}

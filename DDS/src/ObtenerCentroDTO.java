import java.util.*;;

public abstract class ObtenerCentroDTO {
	public ArrayList<CentroDTO> listaCGPs = new ArrayList<CentroDTO>();

	public abstract ArrayList<CentroDTO> obtenerCentrosDTO(String calleOZona); // Metodo Abstracto -> Definir en SubClase
	/*El servicio acepta como parámetro un string que puede corresponder a la calle
	 *  o zona, y devuelve la lista de CGPs disponibles*/
}

import java.util.*;;

public abstract class ObtenerCentroDTO {
	List<CentroDTO> listaCGPs;

	public abstract List<CentroDTO> obtenerCentrosDTO(String calleOZona); // Metodo Abstracto -> Definir en SubClase
	/*El servicio acepta como par�metro un string que puede corresponder a la calle
	 *  o zona, y devuelve la lista de CGPs disponibles*/
}

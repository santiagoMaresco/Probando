import java.util.ArrayList;
import java.util.Iterator;

public class ObtenerCentroDTOPrecargado extends ObtenerCentroDTO {
	
	public ArrayList<CentroDTO> obtenerCentrosDTO(String calleOZona) {
	/*El servicio acepta como parámetro un string que puede corresponder a
	 * la calle o zona, y devuelve la lista de CGPs disponibles */		
		
		// Creo un array de palabras
		int pesoBusqueda;
		ArrayList<CentroDTO> dtos_tmp = new ArrayList<CentroDTO>();
		Iterator<CentroDTO> it = (this.listaCGPs).iterator();
		while (it.hasNext()) {
			CentroDTO i = it.next();

			pesoBusqueda = 0;
			// Busco por calle
			if (i.domicilioCompleto.toLowerCase().contains(calleOZona.toLowerCase())) {
				pesoBusqueda += 1;
			}
			// Busco las zonas
			if (i.zonas.toLowerCase().contains(calleOZona.toLowerCase())) {
				pesoBusqueda += 1;
			}

			if (pesoBusqueda > 0)
				dtos_tmp.add(i);
		}
		return dtos_tmp;
	}

	void agregarCentroDTO(CentroDTO unCGP) {
		(this.listaCGPs).add(unCGP);
	}
}

public class CentroDTO {
	int nroComuna; // número de la comuna (ej: 3)
	String zonas; // zonas que incluye (ej. “Balvanera, San Cristóbal” para la comuna 3)
	String nombreDirector; // nombre del director
	String domicilioCompleto; // domicilio completo del CGP (ej: Junín 521)
	String telefono; // teléfono del CGP (4375-0644/45)
	ServicioDTO[] serviciosDTO; // lista de “serviciosDTO”: array de servicios
}
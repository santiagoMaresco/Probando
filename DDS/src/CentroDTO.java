public class CentroDTO {
	int nroComuna; // n�mero de la comuna (ej: 3)
	String zonas; // zonas que incluye (ej. �Balvanera, San Crist�bal� para la comuna 3)
	String nombreDirector; // nombre del director
	String domicilioCompleto; // domicilio completo del CGP (ej: Jun�n 521)
	String telefono; // tel�fono del CGP (4375-0644/45)
	ServicioDTO[] serviciosDTO; // lista de �serviciosDTO�: array de servicios
}
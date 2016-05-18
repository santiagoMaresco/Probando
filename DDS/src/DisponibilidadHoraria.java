import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DisponibilidadHoraria {
	public int diaDeLaSemana;
	public LocalTime horarioApertura;
	public LocalTime horarioCierre;
	public String descripcion;
	
	/*
	 * SETs y GETs
	 */
	public void setHorario(int unDia, String unaHoraApertura, String unaHoraCierre, String unaDescripcion) {
		this.diaDeLaSemana = unDia;
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
		this.horarioApertura = LocalTime.parse(unaHoraApertura, formatoHora);
		this.horarioCierre = LocalTime.parse(unaHoraCierre, formatoHora);
		this.descripcion = unaDescripcion;
	}
	
	/*
	 * horarioIncluido
	 */
	
	public boolean horarioIncluido(int unDia, String unaHora, String unaDescripcion){
		if(unaDescripcion != null && this.descripcion != unaDescripcion){
			return false;
		}
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime horaParseada = LocalTime.parse(unaHora, formatoHora);
		if((unDia == this.diaDeLaSemana) && (this.horarioApertura.isBefore(horaParseada)) && (this.horarioCierre.isAfter(horaParseada))){
			return true;
		}
		return false;
	}	
	
}

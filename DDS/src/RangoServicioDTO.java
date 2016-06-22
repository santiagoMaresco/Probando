public class RangoServicioDTO {
	int nroDiaSemana; // número de día de la semana (ej: 1 = Lunes, 2 = Martes, etc.)
	int horarioDesde; // horario desde (9)
	int minutosDesde; // minutos desde (0)
	int horarioHasta; // horario hasta (18)
	int minutosHasta; // minutos hasta (0)

	// Constructor
	public RangoServicioDTO(int nroDiaSemana, int horarioDesde, int minutosDesde, int horarioHasta, int minutosHasta) {
		this.nroDiaSemana = nroDiaSemana;
		this.horarioDesde = horarioDesde;
		this.minutosDesde = minutosDesde;
		this.horarioHasta = horarioHasta;
		this.minutosHasta = minutosHasta;
	}
}
import java.util.Iterator;

public class CGP extends Poi {
	/*
	 * compararCercania();
	 * Detalle: Dado un POI y una Interface, te decie si esta cerca o no.
	 * 
	 */
	public boolean compararCercania(Poi unPoi, Interface unaInterface) {
		if(unPoi.comuna == unaInterface.comuna){
			return true;
		}
		return false;
	}
	
	
	/*
	 * estoyDisponibleEl();
	 */
	
	public boolean estoyDisponibleEl(int unDia, String unaHora, String unaDescripcion){
		Iterator<DisponibilidadHoraria> it = (this.misHorarios).iterator();
		while(it.hasNext())
		{
			DisponibilidadHoraria i = it.next();
			if(i.horarioIncluido(unDia, unaHora, unaDescripcion)) return true;
		}				
		return false;
	}
	
}

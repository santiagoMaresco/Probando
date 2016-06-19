import java.util.Iterator;

public class Banco extends Poi {
	
	/*
	 * compararCercania();
	 * Detalle: Dado un POI y una Interface, te decie si esta cerca o no.
	 * 
	 */
	@Override
	public boolean compararCercania(Poi unPoi, double latitudDeTerminal, double longitudDeTerminal,String comunaDeTerminal) {
		if(unPoi.comuna.nombre.equals(comunaDeTerminal)){
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
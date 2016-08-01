import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class BaseDeDatos {
	public Collection<RegistroDeBusqueda> registrosDeBusqueda = new HashSet<RegistroDeBusqueda>();
	

	public void  registrarSolicitud(String texto,String fecha,long tiempoTotalEnSegundos,String terminal){
		RegistroDeBusqueda registroDeBusqueda = new RegistroDeBusqueda();
		registroDeBusqueda.fraseBuscada = texto;
		registroDeBusqueda.tiempoDemorado = tiempoTotalEnSegundos;
		registroDeBusqueda.fecha = fecha;
		registroDeBusqueda.terminal = terminal;
		registrosDeBusqueda.add(registroDeBusqueda);
		}
	
	public int cantidadDeBusquedasSegun(String texto)
	{
		int cantidadDeBusquedas = 0;
		Iterator<RegistroDeBusqueda> it = (this.registrosDeBusqueda).iterator();
		while(it.hasNext())
		{
			RegistroDeBusqueda unRegistro = it.next();
			if(unRegistro.fecha.equals(texto))
				cantidadDeBusquedas ++;
			if(unRegistro.terminal.equals(texto))
				cantidadDeBusquedas ++;
		}
		return cantidadDeBusquedas;
	}
	
	}
	


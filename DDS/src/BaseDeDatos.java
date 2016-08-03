import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.*;


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
	
	public void cantidadDeBusquedasPorFecha(){
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		int contador_tmp = 0;
		
		Iterator<RegistroDeBusqueda> it = (this.registrosDeBusqueda).iterator();
		while(it.hasNext()){
			contador_tmp = 0;
			RegistroDeBusqueda i = it.next();
			if(aMap.containsKey(i.fecha)){
				contador_tmp = aMap.get(i.fecha);
				contador_tmp++;
				aMap.put(i.fecha, contador_tmp);
			} else {
				contador_tmp = 1;
				aMap.put(i.fecha, contador_tmp);
			}
		}
		
		//
		
		aMap.forEach((k,v) -> System.out.println("Fecha: " + k + " Cantidad de busquedas: " + v));
	}
	
	public void cantidadBusquedasPorFraseYTerminal(){
		Map<String, Map<String,Integer>> aMap = new HashMap<String, Map<String,Integer>>();
		Map<String, Integer> aMap2;
		int contador_tmp = 0;
		
		Iterator<RegistroDeBusqueda> it = (this.registrosDeBusqueda).iterator();
		while(it.hasNext()){
			contador_tmp = 0;
			RegistroDeBusqueda i = it.next();
			if(aMap.containsKey(i.fraseBuscada)){
				aMap2 = aMap.get(i.fraseBuscada);
				if(aMap2.containsKey(i.terminal)){
					contador_tmp = aMap2.get(i.terminal);
					contador_tmp++;
					aMap2.put(i.terminal, contador_tmp);
					aMap.put(i.fraseBuscada, aMap2);
				} else {
					contador_tmp = 1;
					aMap2.put(i.terminal, contador_tmp);
					aMap.put(i.fraseBuscada, aMap2);
				}
			} else {
				contador_tmp = 1;
				aMap2 = new HashMap<String, Integer>();
				aMap2.put(i.terminal, contador_tmp);
				aMap.put(i.fraseBuscada, aMap2);
			}
		}
		
		//
		for (Map.Entry<String, Map<String,Integer>> entry : aMap.entrySet()) {
			System.out.println("Frase : " + entry.getKey());
			for (Map.Entry<String, Integer> entry2 : (entry.getValue()).entrySet()) {
				System.out.println("--> Terminal: " + entry2.getKey() + " Cantidad : " + entry2.getValue());
			}
		}
	}
	
}
	


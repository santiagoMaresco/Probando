import java.util.Collection;
import java.util.HashSet;

public class ProcesoAgregarAccionesUsuarios implements Proceso {

	public Collection<ResultadoProceso> resultados = new HashSet<ResultadoProceso>();
	public Usuario user;
	public Permisos nuevoPermiso;
	public ResultadoProceso res = new ResultadoProceso();
	
	public void setUser (Usuario unUser){
		this.user = unUser;
	}
	
	public void determinarPermiso(Permisos unPermiso){
		this.nuevoPermiso = unPermiso;
	}
	
	@Override
	public void ejecutar() {
		res.fechaInicio = user.unMapa.fechaActual();
		res.horaInicio = user.unMapa.horaActual();
		user.permisos.add(nuevoPermiso);
        //Pausa for 2 segundos para que cambie la hora
		try {
		    Thread.sleep(2000);                 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		//Finaliza ejecucion y documento el resultado obtenido
		res.fechaFinalizacion = user.unMapa.fechaActual();
		res.horaFinalizacion = user.unMapa.horaActual();
		resultado();
	}

	@Override
	public void resultado() {
		if(user.permisos.contains(nuevoPermiso)){	
			res.procesoEjecutado = this;
			res.resultado = true;
		}
		else{
			res.procesoEjecutado = this;
			res.resultado = false;
		}

	}
	
	public void deshacer(){ 
		if(user.permisos.contains(nuevoPermiso)){
			user.permisos.remove(nuevoPermiso);
		}
	}

}

import java.util.Collection;
import java.util.HashSet;

public class ProcesoAgregarAccionesUsuarios implements Proceso {

	public Collection<ResultadoProceso> resultados = new HashSet<ResultadoProceso>();
	public Usuario user;
	public Permisos nuevoPermiso;
	
	public void setUser (Usuario unUser){
		this.user = unUser;
	}
	
	public void determinarPermiso(Permisos unPermiso){
		this.nuevoPermiso = unPermiso;
	}
	
	@Override
	public void ejecutar() {
		user.permisos.add(nuevoPermiso);
		resultado();
	}

	@Override
	public void resultado() {
		if(user.permisos.contains(nuevoPermiso)){
			ResultadoProceso res = new ResultadoProceso();
			res.procesoEjecutado = this;
			res.resultado = true;
		}
		else{
			ResultadoProceso res = new ResultadoProceso();
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

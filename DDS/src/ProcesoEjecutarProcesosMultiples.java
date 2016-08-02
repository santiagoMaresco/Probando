import java.util.Collection;
import java.util.HashSet;

public class ProcesoEjecutarProcesosMultiples implements Proceso {
	
	public Collection<Proceso> procesos = new HashSet<Proceso>();
	public Collection<ResultadoProceso> resultados = new HashSet<ResultadoProceso>();
	
	
	public void anidarProcesos(Proceso unProceso){
		this.procesos.add(unProceso);
	}
	
	@Override
	public void ejecutar() {
		for(Proceso unProceso : procesos ){
			unProceso.ejecutar();
		}
	}

	

	@Override
	public void resultado() {
		for(Proceso unProceso : procesos){
			unProceso.resultado();
		}

	}

}

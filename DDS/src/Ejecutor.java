import java.util.Collection;
import java.util.HashSet;

public class Ejecutor {
	
	public Collection<ResultadoProceso> resultados = new HashSet<ResultadoProceso>();
	public Proceso slot;
	
	public void setProceso(Proceso unProceso){
		slot = unProceso;
	}
	
	public void iniciarProceso(){
		slot.ejecutar();
	}
	
	public void resultadoDelProceso(){
		slot.resultado();
	}
}

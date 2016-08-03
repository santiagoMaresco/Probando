import java.util.Collection;
import java.util.HashSet;

public class Usuario {

	public Mapa unMapa;
	public Collection<Permisos> permisos = new HashSet<Permisos>();
	
	public void setMapa (Mapa unM){
		this.unMapa=unM;
	}
	
	public boolean esAdministrador()
	{
		return false;
	}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ProcesoActualizaciónComercios implements Proceso {
	
	public Collection<ResultadoProceso> resultados = new HashSet<ResultadoProceso>();
	Administrador admin = new Administrador();
	//En esta ArrayList meto lo del .txt
	String[] nomYTags;
	
	public void setAdmin (Administrador administrador){
		this.admin=administrador;
	}

	/*
	 * Cargo lo del texto plano a mi variable nomYTags
	 */
	public void ponerContenidoEnLista(String archivo)  {
		String cadena;
		FileReader fr = null;
		try {
			fr = new FileReader(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bf = new BufferedReader(fr);
		try {
			while ((cadena = bf.readLine()) != null) {
				nomYTags=cadena.split(";");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		this.ponerContenidoEnLista("ActualizarComercios.txt");
		
		if (this.nomYTags != null) {
			Poi i = admin.unMapa.obtenerPoi(nomYTags[0]);
			
			if( i == null){
				//Creo el Comercio
				Comercio unComer = new Comercio();
				unComer.setNombre(nomYTags[0]);
				unComer.setTags(nomYTags[1]);
				admin.agregarUnPoi(unComer);
			} else {
				//Modifico los tags del Comercio
				admin.modificarTags(i, nomYTags[1]);
			}
			}
		resultado();
		}

	@Override
	public void resultado() {
		ResultadoProceso resultado = new ResultadoProceso();
		resultado.procesoEjecutado=this;
		Poi i = admin.unMapa.obtenerPoi(nomYTags[0]);
		if( i == null){
			resultado.resultado=false;
		}else{
			resultado.resultado=true;
		}
		this.resultados.add(resultado);
		
	}

}

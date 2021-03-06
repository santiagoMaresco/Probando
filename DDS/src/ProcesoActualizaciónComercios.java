import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

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

		// Fichero del que queremos leer
				File fichero = new File(archivo);
				Scanner s = null;

				try {
					// Leemos el contenido del fichero
					System.out.println("... Leemos el contenido del fichero ...");
					s = new Scanner(fichero);

					// Leemos linea a linea el fichero
					while (s.hasNextLine()) {
						String linea = s.nextLine(); 	// Guardamos la linea en un String
						System.out.println(linea);      // Imprimimos la linea
						nomYTags=linea.split(";");
					}

				} catch (Exception ex) {
					System.out.println("Mensaje: " + ex.getMessage());
				} finally {
					// Cerramos el fichero tanto si la lectura ha sido correcta o no
					try {
						if (s != null)
							s.close();
					} catch (Exception ex2) {
						System.out.println("Mensaje 2: " + ex2.getMessage());
					}
				}
			}
	
	
	
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		this.ponerContenidoEnLista("ActualizarComercios.txt");
		
		if (this.nomYTags != null) {
			Poi i = new Poi();
			i = admin.unMapa.obtenerPoi(nomYTags[0]);
			
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

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class ProcesoActualizaciónComercios implements Proceso {
	
	public Collection<ResultadoProceso> resultados = new HashSet<ResultadoProceso>();
	Administrador admin = new Administrador();
	//En esta ArrayList meto lo del .txt
	String[] nomYTags;
	ResultadoProceso resultado = new ResultadoProceso();
	
	
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
		
		//Comienzo a ejecutar
		resultado.fechaInicio = admin.unMapa.fechaActual();
		System.out.println("fecha de inicio: " + resultado.fechaInicio);
		resultado.horaInicio = admin.unMapa.horaActual();
		System.out.println("hora de inicio: " + resultado.horaInicio);
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
        //Pausa for 2 segundos para que cambie la hora
		try {
		    Thread.sleep(2000);                 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		//Finaliza ejecucion y documento el resultado obtenido
		resultado.fechaFinalizacion = admin.unMapa.fechaActual();
		System.out.println("fecha de finalizacion: " + resultado.fechaFinalizacion);
		resultado.horaFinalizacion = admin.unMapa.horaActual();
		System.out.println("hora de finalizacion: " + resultado.horaFinalizacion);
		resultado();
		}

	@Override
	public void resultado() {
		
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

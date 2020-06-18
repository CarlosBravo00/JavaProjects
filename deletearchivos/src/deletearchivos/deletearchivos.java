package deletearchivos;

import java.io.File;
import java.util.List;

public class deletearchivos {
  public static void main(String[] args) {
	 //Inicialización de variables
    Lconf C = new Lconf();
    leecarpeta L = new leecarpeta();
    lecturalog A = new lecturalog();
    String showlog = "";
    String rutaconf = "config.txt";
    //
    String rutac = C.leeconf(rutaconf, 1); //Lectura del archivo config.txt , para la ruta de la carpeta 
    List<String> Larchivos = L.obdirect(rutac); //Lectura de los archivos en la carpeta 
    System.out.println("Tamaño lista archivos: "+ Larchivos.size());  
    if (Larchivos != null)
      if (!Larchivos.isEmpty()) {
    	  //Si no se encuentra carpeta o no hay archivos no sigue el programa
        String rlog = C.leeconf(rutaconf, 2); //lectura del archivo config.txt ,para la ruta del log
        showlog = C.leeconf(rutaconf, 3); //lectura del archivo config.txt ,para saber si se mostrara el log del programa
        List<String> log = A.leelog(rlog , rutac); //Lectura del log, discriminando información inecesaria para el programa
        System.out.println("Tamaño lista log: "+ log.size()); 
        for (String nombre : Larchivos) {
        	 for (String lineaLog : log) {
        		  if (lineaLog.toUpperCase().contains(nombre.toUpperCase())){ //busca si algun archivo se encuentra en el log
    			  		//proceso para borrar el archvio
        	             String archivo = String.valueOf(rutac) + nombre;
        	             File fichero = new File(archivo);
        	             fichero.delete();
        	             if (showlog.toString().contentEquals("showlog")) {
        	               System.out.println("Delete file:" + archivo); 
        	               break;
        	             }
        		  }
        	 }
        }
      }else {
          System.err.println("La carpeta " + rutac + " esta vacia");
      }  
  }
}

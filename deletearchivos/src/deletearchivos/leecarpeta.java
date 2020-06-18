package deletearchivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class leecarpeta {
  public List<String> obdirect(String directorio) {
    List<String> listNameFiles = new ArrayList<>();
    File f = new File(directorio);
    File[] ficheros = f.listFiles();
    if (f.exists()) {
      for (int x = 0; x < ficheros.length; x++)
        listNameFiles.add(ficheros[x].getName()); 
    } else {
      System.err.println("No se encontro archivo");
    } 
    return listNameFiles;
  }
}

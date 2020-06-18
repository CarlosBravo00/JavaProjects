package deletearchivos;

import java.io.BufferedReader;
import java.io.FileReader;

public class Lconf {
  public String leeconf(String direc, int accion) {
    String ruta = "";
    try {
      BufferedReader bf = new BufferedReader(new FileReader(direc));
      String temp = "";
      int cont = 0;
      String bfread;
      while ((bfread = bf.readLine()) != null) {
        cont++;
        if (accion == cont) {
          temp = String.valueOf(temp) + bfread;
          break;
        } 
      } 
      ruta = temp;
    } catch (Exception e) {
      System.err.println("No se encontro archivo de configuracion");
    } 
    return ruta;
  }
}

package deletearchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class lecturalog {
  public List<String> leelog(String dirconf,String rutac) {
	  List<String> LogLines = new ArrayList<>();
    try {
      BufferedReader bf = new BufferedReader(new FileReader(dirconf));
      String bfread;
      while ((bfread = bf.readLine()) != null) {
    	  if (bfread.toUpperCase().contains(rutac.toUpperCase())) {
    		  LogLines.add(bfread);
    	  }
      }
    } catch (Exception e) {
      System.err.println("No se encontro archivo de log");
    } 
    return LogLines;
  }
}

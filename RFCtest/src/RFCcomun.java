import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;

public class RFCcomun{

	public static void main(String[] args) throws JCoException{ 

        JCoDestination destination = JCoDestinationManager.getDestination("ABAP_AS1");
        JCoFunction function = destination.getRepository().getFunction("ZRFC_CEBM");

        function.getImportParameterList().setValue("LV_IDCLI", "1");
        function.getImportParameterList().setValue("LV_NOMBR", "2");
        function.getImportParameterList().setValue("LV_APELL", "3");
        function.getImportParameterList().setValue("LV_EMAIL", "4");
        function.getImportParameterList().setValue("LV_PAIS", "5");
        function.getImportParameterList().setValue("LV_ESTAD", "6");
        function.getImportParameterList().setValue("LV_CIUDA", "7");	
        function.getImportParameterList().setValue("LV_MUNIC", "8");	
        
        try {
            function.execute(destination);
            System.out.println(function.getExportParameterList().getString("LV_OUTMSG"));
        }
        catch (JCoException ex) {
        	System.out.println(function.getExportParameterList().getString("LV_OUTMSG"));
        }
    }
}
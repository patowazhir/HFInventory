package tests;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.hfinventory.utils.CSVReader;
import com.hfinventory.utils.DBHandler;
import com.hfinventory.utils.Server;

public class ScriptTest {
	public static List<Server> Servers = null;
    private static final String[] hosts = {"CARSON","CAVETT","COLBERT","FALLON","GRIFFIN","IRV-HVHOSTSA01","KIMMEL","ROSE"};
	@Test
    public void test1() throws FileNotFoundException, SQLException {
		CSVReader csvReader = new CSVReader();
		for (String host: hosts){
            if(Servers == null){
                Servers = csvReader.scan("\\\\harpo\\temp\\pato\\scans\\" + host + ".csv");
            }
            else
            {
            List<Server> result = csvReader.scan("\\\\harpo\\temp\\pato\\scans\\" + host + ".csv");
            Servers.addAll(result);
            }
            
            System.out.println(host + ".csv scanned! -- " + Servers.size() + " entries found.");
        } 
        
        
    }
}

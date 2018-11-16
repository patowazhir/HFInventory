import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class HFInventory {

    private static List<Server> Servers = null;
    
    private static String[] hosts = new String[0];
    
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
    	
    	Configuration config = loadConfigFile();

    	CSVReader csvReader = new CSVReader(config);
        csvReader.generateCSV(config.getString("app.scanRoute"));
        
        hosts = config.getString("app.hosts").split(",");
        
        for (String host: hosts){
            if(Servers == null){
                Servers = csvReader.scan(config.getString("app.scanRoute") + host + ".csv");
            }
            else
            {
            List<Server> result = csvReader.scan(config.getString("app.scanRoute") + host + ".csv");
            Servers.addAll(result);
            }
            
            System.out.println(host + ".csv scanned! -- " + Servers.size() + " entries found.");
        } 
        
        DBHandler dbHandler = new DBHandler(config);
        dbHandler.connect();
        dbHandler.addServers(Servers);
        dbHandler.disconnect();  
    }
    
    public static Configuration loadConfigFile() {
    	Configurations configs = new Configurations();
    	Configuration config;
    	try
    	{
    	    config = configs.properties(new File("config.properties"));
    	}
    	catch (ConfigurationException cex)
    	{
    		System.out.println("Configuration failed at loading!.");
    		config = null;
    	}
    	return config;
    }
}

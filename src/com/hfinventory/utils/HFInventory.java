package com.hfinventory.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class HFInventory {

    /**
     * @param args the command line arguments
     */
    
    public static List<Server> Servers = null;
    private static final String[] hosts = {"CARSON","CAVETT","COLBERT","FALLON","GRIFFIN","IRV-HVHOSTSA01","KIMMEL","ROSE"};
    
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        
        CSVReader csvReader = new CSVReader();
        //csvReader.generateCSV("\\\\harpo\\temp\\pato\\scans");
        
        
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
        
        DBHandler dbHandler = new DBHandler();
        dbHandler.connect();
        dbHandler.addServers(Servers);
        dbHandler.disconnect();
        
        
       
        
        
    }
    
}



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration2.Configuration;

public class DBHandler {
	private static String connectionUrl;    
    private Connection conn = null;
    private Statement stmt = null;
    private Configuration config;
    
    public DBHandler(Configuration config) {
    	this.config = config;
    	connectionUrl = "jdbc:sqlserver://"+config.getString("database.host")+";databaseName="+config.getString("database.name")+";user="+config.getString("database.user")+";password="+config.getString("database.password");
    }

    protected void connect() throws SQLException{
        //Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(connectionUrl);
        System.out.println("Connected database successfully...");
    }
    
    protected void disconnect(){
        try{
              if(stmt!=null)
                 conn.close();
           }catch(SQLException se){
           }// do nothing
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }
    }
    
    protected void addServers(List<Server> Servers) throws SQLException{
        
        System.out.println("Inserting records into the table...");
        stmt = conn.createStatement();
        
        for (Server server : Servers){
            if (checkExistsInDB(server.name) == false){
                try{
                String sql = "INSERT INTO Servers (name,host,state,visible) " +
                         "VALUES ('"+server.name+"', '"+server.host+"', '"+server.state+"','0')";
                stmt.executeUpdate(sql);
                System.out.println("Inserted record "+ server.name +" into the table...");
                } catch (SQLException se){
                    se.printStackTrace();
                }
            } else {
                try{
                String sql = "UPDATE Servers " +
                         "SET host='"+server.host+"', state='" +server.state+ "'" +
                        "WHERE name = '" + server.name + "';";
                stmt.executeUpdate(sql);
                System.out.println("Updated record "+ server.name +" with latest values...");
                } catch (SQLException se){
                    se.printStackTrace();
                }
            }
        }
        
        deleteMismatchServers(Servers);
        
    }
    
    protected boolean checkExistsInDB (String name) throws SQLException{
        String sql = "SELECT name FROM Servers WHERE name = " + "'" + name + "'";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
    
    protected ResultSet getServers () throws SQLException{
        String sql = "SELECT name FROM Servers";
        return stmt.executeQuery(sql);
    }
    
    protected boolean checkExistsInList (List<Server> Servers, String serverName){
        for (Server server : Servers){
            if(server.name.equals(serverName)){
                return true;
            }
        }
        return false;
    }
     
    protected void deleteMismatchServers(List<Server> Servers) throws SQLException{
        System.out.println("DELETING NON EXISTENT SERVERS.");
        
        ResultSet serverListRS = getServers();
        List<String> serverList = new ArrayList<>();
        
        
        while (serverListRS.next()){
            String serverName = serverListRS.getString("name");
            serverList.add(serverName);
        }
        
        for(String server:serverList){
            String serverName = server;
            if(checkExistsInList(Servers,serverName) == false){
                System.out.println("Deleting "+ serverName);
                String sql = "DELETE FROM Servers WHERE name = '"+ serverName +"';";
                try{
                stmt.executeUpdate(sql);
                }catch(SQLException se){
                    System.out.println("Deleting "+ serverName + " Failed!");
                }
            }
        }
        System.out.println("DELETING COMPLETE!");
    }  
}

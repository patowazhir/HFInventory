package com.QAServers.utils;
import java.util.List;

public interface ServerDAO
{
    //public void saveServer(Server server);
    public Server getServerByName(String name);
    public void updateServer(Server server);
    //public void deleteServer(int id);
    public List<Server> getAllServers();
}
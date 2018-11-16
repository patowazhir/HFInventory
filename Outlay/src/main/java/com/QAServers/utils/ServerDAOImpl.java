package com.QAServers.utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ServerDAOImpl implements ServerDAO
{

    private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    // Saving a new Server
    public void saveServer(Server server)
    {
        String sql = "insert into Server values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]
        { server.getId(), server.getAge(), server.getDept(), server.getName() });
    }
    */

    // Getting a particular Server
    public Server getServerByName(String name)
    {
        String sql = "select * from Servers where name=?";
        Server server = (Server) jdbcTemplate.queryForObject(sql, new Object[]
        { name }, new RowMapper()
        {
            @Override
            public Server mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Server server = new Server();
                server.setName(rs.getString(1));
                server.setHost(rs.getString(2));
                server.setState(rs.getString(3));
                server.setNotes(rs.getString(4));
                server.setOs(rs.getString(5));
                server.setPurpose(rs.getString(6));
                server.setVersion(rs.getString(7));
                server.setOwner(rs.getString(8));
                server.setSqlVer(rs.getString(9));
                server.setEwaLink(rs.getString(10));
                server.setType(rs.getString(11));
                server.setVisible(rs.getString(12));
                return server;
            }
        });
        return server;
    }

    // Getting all the Servers
    public List<Server> getAllServers()
    {
        String sql = "select * from Servers";

        List<Server> serverList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Server>>()
        {
            @Override
            public List<Server> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Server> list = new ArrayList<Server>();
                while (rs.next())
                {
                    Server server = new Server();
                    server.setName(rs.getString(1));
                    server.setHost(rs.getString(2));
                    server.setState(rs.getString(3));
                    server.setNotes(rs.getString(4));
                    server.setOs(rs.getString(5));
                    server.setPurpose(rs.getString(6));
                    server.setVersion(rs.getString(7));
                    server.setOwner(rs.getString(8));
                    server.setSqlVer(rs.getString(9));
                    server.setEwaLink(rs.getString(10));
                    server.setType(rs.getString(11));
                    server.setVisible(rs.getString(12));
                    list.add(server);
                }
                return list;
            }

        });
        return serverList;
    }

    // Updating a particular Server
    public void updateServer(Server server)
    {
        //String sql = "update Servers set name =?, host=?, state=?, notes=?, os=?, purpose=?, version=?, owner=?, sqlVer=?, ewaLink=?, type=?, visible=? where name=?";
        String sql = "update Servers set host=?, state=?, notes=? where name=?";
        jdbcTemplate.update(sql, new Object[]
        {
			server.getHost(),
			server.getState(),
			server.getNotes(),
			/*
			server.getOs(),
			server.getPurpose(),
			server.getVersion(),
			server.getOwner(),
			server.getSqlVer(),
			server.getEwaLink(),
			server.getType(),
			server.getVisible(),*/
			server.getName()});
    }

    /*
    // Deletion of a particular Server
    public void deleteServer(int id)
    {
        String sql = "delete server where id=?";
        jdbcTemplate.update(sql, new Object[]
        { id });
    }
    */
    
}
package com.QAServers.utils;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServerController
{
    @Autowired
    private ServerDAO serverDAO;

    @RequestMapping(value = "/server",method=RequestMethod.POST)
    public ModelAndView saveServer(@ModelAttribute("server") Server server)
    {
        try
        {
            if(serverDAO.getServerByName(server.getName()) != null);
            serverDAO.updateServer(server);
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("Server doesn't exist!");
            //serverDAO.saveServer(server);
        }
        return new ModelAndView("redirect:/servers");
    }
    
    @RequestMapping(value = "/edit/{name:.+}")
    public ModelAndView editServer(@ModelAttribute("server") Server server,@PathVariable("name") String name)
    {
        ModelAndView model = new ModelAndView("servers");
        
        server = serverDAO.getServerByName(name);
        List serverList = serverDAO.getAllServers();
        
        model.addObject("server",server);        
        model.addObject("serverList",serverList);
        
        return model;
    }
    
    /*
    @RequestMapping(value = "/delete/{name}")
    public ModelAndView deleteServer(@ModelAttribute("server") Server server,@PathVariable("name") int name)
    {
        serverDAO.deleteServer(name);
        
        return new ModelAndView("redirect:/servers");
    }
    */

    @RequestMapping(value = "/servers")
    public ModelAndView listServers(@ModelAttribute("server") Server server)
    {
        ModelAndView model = new ModelAndView("servers");

        List serverList = serverDAO.getAllServers();
        System.out.println(serverList);
        model.addObject("serverList", serverList);
        
        return model;
    }
    
    @RequestMapping(value = "/outlay")
    public ModelAndView listServersOutlay(@ModelAttribute("server") Server server)
    {
        ModelAndView model = new ModelAndView("outlay");

        List serverList = serverDAO.getAllServers();
        System.out.println(serverList);
        model.addObject("serverList", serverList);
        
        return model;
    }
}
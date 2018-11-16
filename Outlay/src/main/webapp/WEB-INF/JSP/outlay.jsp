<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Server Listing</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
   </head>
   <body>
   <div class="container">
	<div class="row">
     <h3>List of Servers</h3>
       <table class="table table-bordered" style="width: 300px">
         <tr>
           <th>Name</th>
           <th>Host</th>
           <th>State</th>
           <th>Notes</th>
         </tr>
         <c:forEach items="${serverList}" var="server">
         <tr>
           <td width="60" align="center">${server.name}</td>
           <td width="60" align="center">${server.host}</td>
           <td width="60" align="center">${server.state}</td>
           <td width="60" align="center">${server.notes}</td>
         </tr>
      </c:forEach>
    </table>
    </div>
    </div>
  </body>
</html>
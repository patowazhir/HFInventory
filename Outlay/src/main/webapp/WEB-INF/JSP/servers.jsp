<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Admin View</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
   </head>
   <body>
   
<div class="container">
	<div class="row">
	<h3>Edit Server!!!</h3>
	      <form:form method="post" action="/Outlay/server.html" commandName="server">
	        <div class="table-responsive">
	          <table class="table table-bordered" style="width: 300px">
	            <tr>
	              <td>Name :</td>
	              <td><form:input type="text" path="name" /></td>
	            </tr>
	            <tr>
	              <td>Host :</td>
	              <td><form:input type="text" path="host" /></td>
	            </tr>
	            <tr>
	              <td>State :</td>
	              <td><form:input type="text" path="state" /></td>
	            </tr>
	            <tr>
	              <td>Notes :</td>
	              <td><form:input type="text" path="notes" /></td>
	            </tr>
	            <tr>
	              <td></td>
	              <td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
	            </tr>
	          </table>
	        </div>
	      </form:form>
      </div>
     <br>
     <div class="row">
     <h3>List of Servers</h3>
       <table class="table table-bordered" style="width: 300px">
         <tr>
           <th>Name</th>
           <th>Host</th>
           <th>State</th>
           <th>Notes</th>
           <th>Edit</th>
         </tr>
         <c:forEach items="${serverList}" var="server">
         <tr>
           <td width="60" align="center">${server.name}</td>
           <td width="60" align="center">${server.host}</td>
           <td width="60" align="center">${server.state}</td>
           <td width="60" align="center">${server.notes}</td>
           <td width="60" align="center"><a href="edit/${server.name}">Edit</a></td>
         </tr>
      </c:forEach>
    </table>
    </div>
    </div>
  </body>
</html>
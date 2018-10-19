<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
        url="jdbc:sqlserver://MPS-QA-APP01\\SQL2016;databaseName=QAServers;"
        user="sa" password="Epicor123"
    />
     
    <sql:query var="listServers"   dataSource="${myDS}">
        SELECT * FROM Servers WHERE state = 'Running';
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of servers</h2></caption>
            <tr>
                <th>Name</th>
                <th>Host</th>
                <th>State</th>
            </tr>
            <c:forEach var="server" items="${listServers.rows}">
                <tr>
                    <td><c:out value="${server.name}" /></td>
                    <td><c:out value="${server.host}" /></td>
                    <td><c:out value="${server.state}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

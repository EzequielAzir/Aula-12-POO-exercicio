<%-- 
    Document   : index
    Created on : 9 de mai. de 2022, 16:15:50
    Author     : Fatec
--%>

<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Exception requestEx = null;
    ArrayList<Cliente> list = new ArrayList<>();
    try {
        list = Cliente.getList();
    } catch (Exception e) {
        requestEx = e;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - JDBC | Artistas</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2>Lista de clientes</h2>
        <%if (requestEx != null) {%>
        <h3 style="color: red"><%= requestEx.getMessage()%></h3>
        <%}%>
        <table border="1">
            <tr><th>id</th><th>name</th></tr>
                <%for (Cliente a : list) {%>
        <tr>
        <td><%= a.getId()%></td>
        <td><%= a.getName()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
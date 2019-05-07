<%-- 
    Document   : listar
    Created on : 6/05/2019, 02:39:21 PM
    Author     : SQA
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.testWebb.bean.BeanUsuario"%>
<%@page import="com.testWebb.dao.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Personas</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>nombre</th>
                        <th>apellido</th>
                        <th>documento</th>
                        <th>celular</th>
                    </tr>
                </thead>
                <%
                    DaoUsuario dao = new DaoUsuario();
                    List<BeanUsuario> listUs = dao.listar();
                    Iterator<BeanUsuario> iter= listUs.iterator();
                    BeanUsuario usu=null;
                    while(iter.hasNext()){
                        usu=iter.next();
                    %>
                <tbody>
                    <tr>
                        <td><%= usu.getIdUsuario()%></td>
                        <td><%= usu.getNombre()%></td>
                        <td><%= usu.getApellido()%></td>
                        <td><%= usu.getDocumento()%></td>
                        <td><%= usu.getCelular()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>

<%-- 
    Document   : bemvindo
    Created on : 27/06/2017, 05:20:30
    Author     : Jomar
--%>

<%@page import="br.com.crescer.aula4.model.Genero"%>
<%@page import="java.util.List"%>
<%@page import="br.com.crescer.aula4.repository.GenericDao"%>
<%@page import="br.com.crescer.aula4.model.GeneroDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <body>
    <table>
      <%
      GenericDao dao = new GeneroDao();
      List<Genero> generos = dao.findAll();
      
      for (Genero genero : generos ) {
      %>
        <tr>
          <td><%=genero.getDescricao()%></td> 
        </tr>
      <%
      }
      %>
    </table>
  </body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jomar
 */
@WebServlet(
    name = "Login", 
    urlPatterns = {"/login"},
    initParams  = {
        @WebInitParam(name = "login", value = "jomar"),
        @WebInitParam(name = "senha", value = "123456"),
        @WebInitParam(name = "nome", value = "")}
    )

public class LoginServlet extends HttpServlet{

    private String login;
    private String senha;
    private Set<String> clientes = new HashSet<>();
    private String nome;
 
    
    @Override
    public void init(ServletConfig config) throws ServletException {
      super.init(config);
      this.login = config.getInitParameter("login");
      this.senha = config.getInitParameter("senha");
      this.nome = config.getInitParameter("nome");
    }

    @Override 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (final PrintWriter out = resp.getWriter();) { 
            // escreve o texto
            out.append("<!DOCTYPE html>"); 
            out.append("<html>"); 
            out.append("<head>"); 
            out.append("<title>Java - aula5</title>"); 
            out.append("<meta charset=\"UTF-8\">"); 
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"); 
            out.append("</head>"); 
            out.append("<body>");
            
//            out.append("<form action=\"/aula5/login\" method=\"POST\">\n"); ;
//            out.append("<label for=\"login\">Nome</label>");
//            out.append(" <input name=\"login\"/>\n"); 
//            out.append(" <input type=\"submit\" value=\"EnviarLogin\" />    \n"); 
//            out.append("</form>");  
            
            out.append("<form action=\"/aula5/login\" method=\"POST\">\n"); 
            out.append("<label for=\"name\">Nome</label>");
            out.append(" <input name=\"nome\" autofocus/>\n"); 
            out.append(" <input type=\"submit\" value=\"Enviar\" />    \n"); 
            out.append("</form>");  
            
            out.append("<table class=\"table table-hover\"><thead><tr><th>Nome</th></tr></thead><tbody>");             
            clientes.forEach(nome -> out.append("<tr><td>").append(nome).append("</td></tr>")); 
            out.append("</tbody></table>"); 
            
            out.append("</body>"); 
            out.append("</html>"); 
        }
    }
    
    @Override 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        final String nome = req.getParameter("nome"); 
        if (nome != null) { 
            clientes.add(nome); 
        } 
        resp.sendRedirect("/aula5/login"); 
    } 
}

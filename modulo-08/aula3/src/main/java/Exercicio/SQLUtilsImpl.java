/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;


import br.com.crescer.aula3.ConnectionUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pais;


/**
 *
 * @author Jomar
 */
public class SQLUtilsImpl implements SQLUtils{
    
     private static final String LOAD_PAIS = "SELECT * FROM PAIS WHERE ID = ?"; 

    @Override
    public void runFile(String filename) {
        LeituraImpl leituraImpl = new LeituraImpl();
        String query = leituraImpl.read(filename);
        try (final Statement statement 
                = ConnectionUtils.getConnection().createStatement()) {              
            statement.executeQuery(query);
        } catch (final SQLException e) { 
                System.err.format("SQLException: %s", e); 
        }
    }

    @Override
    public String executeQuery(String query) {
        String retorno = "";
        try(final Statement statement
                = ConnectionUtils.getConnection().createStatement()){
            try(final ResultSet resultSet = statement.executeQuery(query)) {                
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                while (resultSet.next()) { 
                    for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                        retorno = retorno.concat(resultSetMetaData.getColumnName(i) + ": ");
                        retorno = retorno.concat(resultSet.getString(i));
                    }                                        
                } 
            }
        } catch (SQLException ex) {
             Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public void importCSV(File file, String tabela) {    
        final StringBuilder query = new StringBuilder();
        try (   final Reader reader = new FileReader(file); 
                final BufferedReader bufferReader = new BufferedReader(reader)) {             
            String readLine = bufferReader.readLine();                      
            int contColunas = readLine.split("/,/").length;
            query.append("INSERT INTO ").append(tabela).append(" (").append(readLine).append( " ) VALUES ( ");
            for(int i=0; i<contColunas; i++) {
                query.append(" ?,");
            }
            query.deleteCharAt(query.toString().trim().length() - 1); 
            query.append(")");            
            while (true) { 
                try{
                    query.append(bufferReader.readLine()).append("\n");
                }
                catch (NullPointerException e){
                     break;
                }                
            }            
        } catch (IOException ex) {
             Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {              
            statement.executeQuery(query.toString());
        } catch (SQLException ex) {
             Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public File exportCSV(String query, String arquivo) {
         return null;
    }

    
    public static void main(String[] args) throws SQLException {
        SQLUtils sqlUtils = new SQLUtilsImpl();
        sqlUtils.runFile("file/leitura.sql");
        if(ConnectionUtils.getConnection().isValid(0)){
            System.out.println("ok");
        }
        System.out.println(Long.valueOf(1));
    
    }
 
}

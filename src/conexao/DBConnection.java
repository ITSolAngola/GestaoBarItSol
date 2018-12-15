/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bacar
 */
public class DBConnection {
    
    static Connection connection=null;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/gestaobar";
            connection=DriverManager.getConnection(url, "root","");
            System.out.println("Conectado");
        }catch(Exception e){
            
        }
        return connection;
    }
    
    public static void main(String[] args){
        getConnection();
    }
    
}

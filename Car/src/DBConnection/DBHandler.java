/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus-pc
 */
public class DBHandler extends Configs {
    
    Connection dbconnection;
    public Connection getConnection() throws SQLException{
        
        String connectionString= "jdbc:mysql://" + Configs.dbhost+":" + Configs.dbport+ "/" + Configs.dbname+"?autoReconnect=true&useSSL=false";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        dbconnection=DriverManager.getConnection(connectionString,Configs.dbuser,Configs.dbpass);
        
        System.out.println("dbhandler");
        
        return dbconnection;
    }
}

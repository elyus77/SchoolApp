/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elyus77
 */
public class DB {
    
    static String URL = "localhost:3306/";
    static String DATABASE_NAME = "deploy";
    static String USERNAME = "root";
    static String PASSWORD = "";
    
    public static Connection getConnection() throws ClassNotFoundException{
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + URL + DATABASE_NAME, USERNAME, PASSWORD);
        }catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }
        return con;
    }
    
}

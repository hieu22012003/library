/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author Admin
 */

import java.sql.*;
public class Connector {
    public final static String connectionString = "jdbc:mysql://localhost:3306/T2108M";
    public final static String user = "root";
    public final static String password = "root";

    private static Connector instance;

    private Connection conn;
    Connector() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        // tao connect
        conn = DriverManager.getConnection(connectionString,user,password);
    }

    public static Connector getInstance() throws Exception{
        if(instance == null){
            instance = new Connector();
        }
        return instance;
    }

    public PreparedStatement getStatement(String sql) throws Exception{
        PreparedStatement statement = conn.prepareStatement(sql);
        return statement;
    }
}

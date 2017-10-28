/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBUtils {
    private final String url = "jdbc:mysql://localhost:3306/crmsystem";    
    private final String username = "root";
    private final String password = "admin";
    private Connection connection;
    private static DBUtils instance;

    
    public Connection getConnection() {
        try {
            if(connection == null || connection.isClosed())
                connect();
        } catch (SQLException ex) {
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static DBUtils getInstance(){
        if(instance == null)
            instance = new DBUtils();
        return instance;
    }
    
    private void connect(){
          try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password); 
//            connection.
            System.out.println("Connection established succesfull");
        } catch (SQLException ex) {            
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
//              System.out.println(DBConnect.class.getName());
//              System.out.println(ex);
        }  
    }
    
    public void closeConnection(){
        
        try {
            connection.close();
        } catch (SQLException ex) {
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
//    public List<String> getDrinks() throws SQLException{
////        Connection connection = ConnectDB();
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("select * from position");
//        List<String> stringList = new ArrayList<>();
//        while (rs.next()){
//                stringList.add(rs.getString("namePosition"));
//        }
//        return stringList;
//    }
//    
//    public ResultSet executeStatement(String query) throws SQLException{
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery(query);
//        return rs;
//    }


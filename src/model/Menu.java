/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author HP
 */
public class Menu extends Repository<MenuItem>{
//    private final List<MenuItem> menu = new ArrayList<>();
    private static Menu instance;
    
    private Menu(){
        super.setNameList("select * from menu", resultSet -> wrapConstructor(resultSet));
    }
  
    public static Menu getInstance(){
        return instance == null ? instance = new Menu() : instance;
    }
    
    private MenuItem wrapConstructor(ResultSet resultSet){
        try{
            return new MenuItem(resultSet.getString("idMenu"), 
                    resultSet.getString("idPosition"), 
                    resultSet.getString("idVolume"), 
                    resultSet.getFloat("cost"));
        } catch (SQLException ex){
            throw new RuntimeException("Error during creation list of MenuItems: " + ex.getMessage());
        }
    }
    
//    private void initMenu(){
//        try {
//            ResultSet rs = DBUtils.getInstance().getConnection().createStatement().executeQuery("select * from menu");
//            while(rs.next()){
//                menu.add(new MenuItem(rs.getString("idMenu"), rs.getString("idPosition"), rs.getString("idVolume"), rs.getFloat("cost")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Positions.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DBUtils.getInstance().closeConnection();
//    }
    
    public float getCost(String idPosition, String idVolume){
        Optional<MenuItem> menuItem = list.stream()
                .filter(x -> x.getIdPosition().equals(idPosition) & x.getIdVolume().equals(idVolume))
                .findAny();
        return menuItem.get().getCost();
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repositories;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import model.entities.*;
import model.repositories.IContainer;

/**
 *
 * @author HP
 */
public class Positions extends Repository<Position> implements IContainer{
//    List<Position> listPositions = new ArrayList<>();
    private static Positions instance;
    
    public static Positions getInstance(){
        return instance == null ? instance = new Positions(): instance; 
    }
    
    private Positions(){   
        super.setNameList("select * from position", resultSet -> wrapConstructor(resultSet));      
    }
    
    @Override
    public Map<String, String> getNameList() {
//        if (list.isEmpty()) setNameList();
        Map<String, String> map = new HashMap<>();
        list.forEach((position) -> {
            map.put(position.getId(), position.getName());
        });        
        return map;
    }
    
//    private void setNameList(){        
//        super.setNameList("select * from position", resultSet -> wrapConstructor(resultSet));      
//    }
    
    private Position wrapConstructor(ResultSet resultSet){
        try{
            return new Position(resultSet.getString("idPosition"), 
                resultSet.getString("namePosition"), 
                resultSet.getString("idType"));
        } catch (SQLException ex){
            throw new RuntimeException("Error during creation list of Positions: " + ex.getMessage());
        }
    }
    
//    public Position getEntityById(String id){
//        return list.stream().
//                filter(position -> id.equals(position.getId())).
//                findFirst().
//                get();
//    }
}

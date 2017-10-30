/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import model.entities.Volume;
import java.util.Map;

/**
 *
 * @author HP
 */
public class Volumes extends Repository<Volume> implements IContainer{

//    private List<Volume> listVolumes = new ArrayList<>();
    private static Volumes instance;
    
    public static Volumes getInstance(){
        return instance == null ? instance = new Volumes() : instance;
    }
    
    public Volumes(){
        super.setNameList("select * from volume", resultSet -> wrapConstructor(resultSet));
    }
    
    private Volume wrapConstructor(ResultSet resultSet){
        try{
            return new Volume(resultSet.getString("idVolume"), 
                resultSet.getString("valueVolume"));
        } catch (SQLException ex){
            throw new RuntimeException("Error during creation list of Volumes: " + ex.getMessage());
        }            
    }
    
    @Override
    public Map<String, String> getNameList() {
//        if (listVolumes.isEmpty()) setNameList();
        Map<String, String> map = new HashMap<>();
        list.forEach((volume) -> {
            map.put(volume.getId(), volume.getName());
        });        
        return map;
    }  
    
//    private void setNameList(){
//        try {
//            ResultSet rs = DBUtils.getInstance().getConnection().createStatement().executeQuery("select * from volume");
//            while(rs.next()){
//                listVolumes.add(new Volume(rs.getString("idVolume"), rs.getString("valueVolume")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Positions.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DBUtils.getInstance().closeConnection();
//    }
    
}

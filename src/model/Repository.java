/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DB.DBUtils;


/**
 *
 * @author HP
 */
public abstract class Repository<T> {
    
    protected List<T> list = new ArrayList<>();
//    protected static Entity instance;
    
//    protected Entity(){}
    
//    public static Entity getI nstance(){
//        return instance == null ? instance = new Entity() : instance;
//    }
//    protected Map<String, String> getNameList(Function<T, String> fun){
//        Map<String, String> map = new HashMap<>();        
//        list.forEach((position) -> map.put(fun.app);        
//        return map;
//    }
//    
//    public abstract Map<String, String> getNameList();
    
    public void setNameList(String query, Function<ResultSet, T> fun){
        
        try {
            ResultSet rs = DBUtils.getInstance().getConnection().createStatement().executeQuery(query);
            while(rs.next()){
                list.add(fun.apply(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Positions.class.getName()).log(Level.SEVERE, null, ex);
        }
        DBUtils.getInstance().closeConnection();  
    }
}

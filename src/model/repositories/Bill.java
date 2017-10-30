/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repositories;

import java.util.ArrayList;
import java.util.List;
import model.entities.*;

/**
 *
 * @author HP
 */
public class Bill {
    private List<BillPosition> list = new ArrayList<>();
    
    public void createBillPosition(){
        list.add(new BillPosition());        
    }
    
    public void addDataToBill(Entity entity){
        
        if(entity instanceof Position){
            list.get(list.size()).setPosition((Position)entity);
        }
        if(entity instanceof Volume){
            list.get(list.size()).setVolume((Volume)entity);
        }
    }
    
    public void insertBill(){
        
    }
    
    @Override
    public String toString(){
        StringBuilder resultString = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            resultString.append("/").
                    append(i).
                    append(" ").
                    append(list.get(i)).
                    append("\n");
        }
        return resultString.toString();
    }
}

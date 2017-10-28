/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Bill {
    private List<BillPosition> list = new ArrayList<>();
    
    public void createBillPosition(){
        list.add(new BillPosition());        
    }
    
    public void addName(){
        list.get(list.size()).setName(name);        
    }
    
    public void addVolume(){
        list.get(list.si)
    }
    
    
    public void insertBill(){
        
    }
    
    public void addToPositionData(String nameAttribute, String valueAttribute){
        
    }
}

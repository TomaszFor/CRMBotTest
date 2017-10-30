/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import model.entities.*;
import model.repositories.*;

/**
 *
 * @author HP
 */
public class BillManager {
    private Bill bill;
    
    public void createBill(){
        if(bill == null) 
            bill = new Bill();
    }
    
    public void clearBill(){
        bill = null;
    }
    
    public void createBillPosition(){
        bill.createBillPosition();
    }
        
    public void addPositionToBill(String data){
        bill.addDataToBill(Positions.getInstance().getEntityById(data));
    }
    
    public void addVolumeToBill(String id){
        bill.addDataToBill(Volumes.getInstance().getEntityById(id));
    }
    
//    public List<Volume> getAvailableVolumes(String idPosition){
//        
//    }
    
    
}

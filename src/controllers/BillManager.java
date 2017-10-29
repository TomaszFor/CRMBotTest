/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Bill;

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
    
    public void addDataToBill(String attribute, String data){
        bill.addToPositionData(attribute, data);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author HP
 */
public class Position extends Entity{

    private final String idType;
    
    public Position(String id, String name, String idType){
        super(id, name);
        this.idType = idType;
    }

    public String getidType() {
        return idType;
    }

//    @Override
//    public String getId() {
//        return id;
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
    
    
}

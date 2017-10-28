/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class Position{
    private String id;
    private String name;
//    private float cost;
    private String idType;
    
    public Position(String id, String name, String idType){
        this.id = id;
        this.name = name;
        this.idType = idType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getidType() {
        return idType;
    }
}

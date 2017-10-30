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
public class Entity {
    protected final String id;
    protected final String name;

    protected Entity(){
        this.id = "undefined";
        this.name = "undefined";
    }
        
    protected Entity(String id){
        this.id = id;
        this.name = "undefined";
    }    
    
    protected Entity(String id, String value) {
        this.id = id;
        this.name = value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

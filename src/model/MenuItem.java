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
public class MenuItem {
    
    private String id;
    private String idPosition;
    private String idVolume;
    private float cost;

    public MenuItem(String id, String idPosition, String idVolume, float cost) {
        this.id = id;
        this.idPosition = idPosition;
        this.idVolume = idVolume;
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }
    
    public String getIdPosition(){
        return idPosition;
    }
    
    public String getIdVolume(){
        return idVolume;
    }
}

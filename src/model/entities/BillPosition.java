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
public class BillPosition {
    
//    private String name;
//    private String volume;
    
    private Position position;
    private Volume volume;
    private float cost;

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public Position getPosition() {
        return position;
    }
    
    public Volume getVolume() {
        return volume;
    }

//    }
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return position.getName() + ' ' + volume.getName() + '\n' + cost;
    }
}

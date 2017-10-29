/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.strategy.IAlgorithm;

/**
 *
 * @author HP
 */
public class Strategy {
    IAlgorithm algorithm;
    
    public void setAlgorithm(IAlgorithm algorithm){
        this.algorithm = algorithm;
    }
    
    public void runAlgorithm(){
        algorithm.execute();
    }
}

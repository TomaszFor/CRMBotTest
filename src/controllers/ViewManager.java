/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Repository;
import model.IContainer;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import view.Keyboard;
import view.Text;

/**
 *
 * @author HP
 */
public class ViewManager {
    private Keyboard keyboard;
    private Text textMessage;
    private ReplyKeyboard currentKeyboard;
    
    public ViewManager(){
        this.keyboard = new Keyboard();
    }
    
    public ReplyKeyboard getKeyboard(){
        return this.currentKeyboard;
    }
    
    public void setReplyKeyboard(){
        this.currentKeyboard = keyboard.getReplyKeyboardMarkup();
    }
    
    public void setInlineKeyboard(IContainer container){
        this.currentKeyboard = keyboard.getInlineKeyboardMarkup(container.getNameList());
    }
    
}

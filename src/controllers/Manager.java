/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Positions;
import model.Volumes;
import org.telegram.telegrambots.api.methods.send.SendMessage;

public class Manager {
    
    private SendMessage sendMessage;
    private Command currentCommand, nextCommand;
    private InputManager inputManager;
    private ViewManager viewManager;
    private BillManager billManager;
    private String billAttribute;

    public InputManager getInputManager() {
        return inputManager;
    }

    public Manager(){
        this.inputManager = new InputManager();
        this.viewManager = new ViewManager();
    }
    
    public void run(){
        commandSwitcher();
        initSendMessage();
    }
    
    public SendMessage getSendMessage() {
//        updateBill(command, inputManager.getData());
//        commandSwitcher();
//        initSendMessage();
        return sendMessage;
    }
    
    private void initSendMessage(){
        this.sendMessage = new SendMessage();
        this.sendMessage.setChatId(this.inputManager.getChatId());
        this.sendMessage.setParseMode("markdown");        
        this.sendMessage.setReplyMarkup(this.viewManager.getKeyboard());
        this.sendMessage.setText("text");
    }
    
    private void commandSwitcher(){
        
        if ((currentCommand = inputManager.getCommand()) == Command.NONE) currentCommand = nextCommand;
        
        switch(currentCommand){
            case START:   
                viewManager.setReplyKeyboard();
                break;
                
            case ADD_POSITION:                
                viewManager.setInlineKeyboard(Positions.getInstance());
                nextCommand = Command.ADD_VOLUME;
                break;
                
            case ADD_VOLUME:   
                viewManager.setInlineKeyboard(Volumes.getInstance());                
                break;
        }        
    }
    
    private void updateBill(Command command, String data){
        billManager.createBill();
        billManager.addDataToBill(inputManager.getParsedDataByIndex(0), inputManager.getParsedDataByIndex(1));
        
    }
}

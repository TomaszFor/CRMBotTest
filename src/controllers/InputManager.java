/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.telegram.telegrambots.api.objects.Update;
import utils.Parser;

/**
 *
 * @author HP
 */
public class InputManager {
    
    private Long chatId = null;
    private String data = null;
    
    public Long getChatId(){                       
        return chatId;
    }

    public String getData() {
        return data;
    }

    public void setUpdate(Update update) {
                
        if(update.hasMessage()){
           this.chatId = update.getMessage().getChatId();
           this.data = update.getMessage().getText();
        }   
        if(update.hasCallbackQuery()){
            this.chatId = update.getCallbackQuery().getMessage().getChatId();
            this.data = update.getCallbackQuery().getData();
        }
        if(update.hasEditedMessage()){
            this.chatId = update.getEditedMessage().getChatId();
        }        
    }
    
    public Command getCommand(){
        Parser parser = new Parser(data);
        String parsedCommand = parser.getTokenList().get(0);
        switch(parsedCommand){
            case "start" : return Command.START;
            case "Add": return Command.ADD_POSITION;
            case "Cancel": return Command.CANCEL_POSITION;        
            default: return Command.NONE;
        }        
    }
}

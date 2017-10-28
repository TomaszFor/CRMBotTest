/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

/**
 *
 * @author HP
 */
public class Keyboard {

    protected InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    protected Map<String, String> buttonNames = new HashMap<>();
    protected final List<String> replyKeyboardList = Arrays.asList("Add Position", "Cancel Position", "Additions");
    protected ReplyKeyboard kb;

    public InlineKeyboardMarkup getInlineKeyboardMarkup(Map<String, String> buttonNames){ 
     List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();        
        Iterator<Entry<String, String>> iterator = buttonNames.entrySet().iterator();
        
        for(int i = 0; i < buttonNames.size()/4 + 1; i++){
            
            List<InlineKeyboardButton> keyboardRow = new ArrayList<>();            
            
            for(int j = 0; j < 4 && iterator.hasNext(); j++){   
                InlineKeyboardButton button = new InlineKeyboardButton();
                Entry<String, String> buttonData = iterator.next();
                button.setCallbackData(buttonData.getKey());
                button.setText(buttonData.getValue());
                keyboardRow.add(button);
            }
            keyboard.add(keyboardRow);                
        }              
        

        return this.inlineKeyboardMarkup.setKeyboard(keyboard);        
    }

    public ReplyKeyboardMarkup getReplyKeyboardMarkup(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        replyKeyboardList.forEach((buttonName) -> {
            row.add(buttonName);
        });
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setResizeKeyboard(Boolean.TRUE);
        return replyKeyboardMarkup;
    }
}

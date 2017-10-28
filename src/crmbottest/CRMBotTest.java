/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crmbottest;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.api.methods.ParseMode;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.exceptions.TelegramApiValidationException;
import controllers.*;

/**
 *
 * @author HP
 */
public class CRMBotTest extends TelegramLongPollingBot{

    /**
     * @param args the command line arguments
     */
    private Manager manager;

    {
        manager = new Manager();        
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new CRMBotTest());
        }catch (TelegramApiException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public String getBotToken() {
        return "338733924:AAHert9hmTWnlhxeQHaQXa4QRLJvbkfqhfg";
    }
    
    @Override
    public String getBotUsername() {
        return "MrMokkoBot";
    }
    
    @Override
    public void onUpdateReceived(Update update) {
                
        manager.getInputManager().setUpdate(update);
                
        try{
            sendMessage(manager.getSendMessage());
        }catch(TelegramApiException ex){
            System.out.println(ex.getMessage() + ex.getClass());
        }
    }    
}

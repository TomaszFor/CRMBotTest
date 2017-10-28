/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author HP
 */
public class Parser {
    private StringTokenizer tokenizer = null;
    private final String delimeters = " ;/.,";
    private List<String> tokens = new ArrayList<>();
    
    public Parser(String message){
        tokenizer = new StringTokenizer(trimSlash(message), delimeters);  
    }
    
    private void getTokens(){
        while(tokenizer.hasMoreTokens()){
            tokens.add(tokenizer.nextToken());
        }
    } 
    
    private String trimSlash(String message){
        if(message.charAt(0) == '/'){
            return message.substring(1);
        } else {
            return message;
        }            
    }
    
    public List<String> getTokenList(){
        getTokens();
        return this.tokens;
    }    
}

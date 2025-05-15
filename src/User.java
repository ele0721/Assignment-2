/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 345700744
 */
public class User {
    private String username;
    private int password;
    private Mode chooseMode;
    
    public User(String username, int password){
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public int getPassword(){
        return password;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(int password){
        this.password = password;
    }
    
    public Mode chooseMode(){
        return chooseMode;
    }
}

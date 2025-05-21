
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
    private String password;
    private Mode chooseMode;
    private static final String USER_FILE = "users.txt";
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public Mode chooseMode(){
        return chooseMode;
    }
    
    public boolean signUp() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE, true));
            writer.println(username + "," + password);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error signing up: " + e.getMessage());
            return false;
        }
    }

    public boolean login() {
        try {
            Scanner scanner = new Scanner(new File(USER_FILE));
            while (scanner.hasNextLine()) {
                String[] userData = scanner.nextLine().split(",");
                if (userData[0].trim().equals(username) && userData[1].trim().equals(password)) {
                    return true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        }

        System.out.println("Invalid username or password.");
        return false;
    }
}

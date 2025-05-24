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
 * @author Helen
 */
public class User {
    private String username;
    private String password;
    private Mode mode;
    private static final String USER_FILE = "users.txt";
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.mode = null;
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
       
    /**
     * Assigns a mode to the user.
     * @param mode The mode to assign
     */
    public void setMode(Mode mode) {
        this.mode = mode;
        mode.setMode(username);
    }

    /**
     * Retrieves the current mode assigned to the user.
     * @return The assigned mode
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * Store the user's username and password in the user file and create a personal bookmark file
     * @return True if sign-up is successful, false otherwise
     */
    public boolean signUp() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE, true));
            writer.println(username + "," + password);
            writer.close();
            new File(getBookmarkFile()).createNewFile();
            return true;
        } catch (IOException e) {
            System.out.println("Error signing up: " + e.getMessage());
            return false;
        }
    }

     /**
     * Logs in the user by checking the information in the user file.
     * @return True if login is successful, false otherwise
     */
    public boolean login() {
        try {
            Scanner scanner = new Scanner(new File(USER_FILE));
            while (scanner.hasNextLine()) {
                String[] userData = scanner.nextLine().split(",");
                if (userData[0].trim().equals(username) && userData[1].trim().equals(password)) {
                    //Set the username when user logs in and tracks their score
                    Score.getInstance().setCurrentUsername(username); 
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
    
     /**
     * Retrieves the bookmark file name associated with the user.
     * @return The user's bookmark file name
     */
    public String getBookmarkFile() {
        return "bookmark_" + username + ".txt";
    }
}

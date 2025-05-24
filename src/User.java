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

    // Constructor
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.mode = null;
    }

    /**
     * Retrieves the username of the user.
     * @return The username
     */
    public String getUsername(){
        return username;
    }

    /**
     * Retrieves the password of the user.
     * @return The password
     */
    public String getPassword(){
        return password;
    }
       
    /**
     * Assigns a mode to the user.
     * @param mode The mode to assign
     */
    public void setMode(Mode mode) {
        this.mode = mode;
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
            PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE, true)); // Open writer to append to USER_FILE
            writer.println(username + "," + password); // Store user's information
            writer.close();
            new File(getBookmarkFile()).createNewFile(); // Create bookmark file for user
            return true;
        } catch (IOException e) {
            System.out.println("Error signing up: " + e.getMessage()); // Display message if an error occurs
            return false;
        }
    }

     /**
     * Logs in the user by checking the information in the user file.
     * @return True if login is successful, false otherwise
     */
    public boolean login() {
        try {
            Scanner scanner = new Scanner(new File(USER_FILE)); // Open scanner to read USER_FILE
            // Read each line and split username and password
            while (scanner.hasNextLine()) {
                String[] userData = scanner.nextLine().split(",");
                // If User is found, return true
                if (userData[0].trim().equals(username) && userData[1].trim().equals(password)) {
                    //Set the username when user logs in and tracks their score
                    Score.getInstance().setCurrentUsername(username); 
                    return true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage()); // Display message if an error occurs
        }
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

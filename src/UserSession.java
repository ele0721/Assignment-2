/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Helen
 */
public class UserSession {
    private static UserSession instance;
    private User currentUser;
    
    // Constructor
    private UserSession() {} 
    
    /**
     * Retrieves the single instance of UserSession.
     * @return The instance
     */
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    /**
     * Sets the current user.
     * @param user The user to set
     */
    public void setUser(User user) {
        this.currentUser = user;
    }

    /**
     * Retrieves the current user.
     * @return The current user
     */
    public User getUser() {
        return currentUser;
    }
}

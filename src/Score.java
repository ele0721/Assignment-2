/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Score {
    private int score;
    private String currentUsername;
    
    public Score() {
      this.score = 0;  
      this.currentUsername = "";
    }
    
    public void incrementScore() {
        score++;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void setCurrentUsername(String username) {
        this.currentUsername = username;
    }
    
    public String getCurrentUsername() {
        return currentUsername;
    }
    
    public void submitToLeaderboard() {
        if(currentUsername != null && !currentUsername.isEmpty()) {
            setLeaderboard.getInstance().addScore(currentUsername, score);
        }
    }
    
    @Override
    public String toString() {
        return "Score: " + score;
    }
    
    //Creates one instance of the Score class when the class is loaded, and is only accessible within the class
    private static final Score instance = new Score();
    
    //A satic method that returns this instance, giving access to other classes
    public static Score getInstance() {
        return instance;
    }
    
}

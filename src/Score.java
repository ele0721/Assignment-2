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
    
    public Score() {
      this.score = 0;  
    }
    
    public void incrementScore() {
        score++;
    }
    
    public int getScore() {
        return score;
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

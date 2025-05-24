/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Mode {
    private boolean quizMode;
    private boolean learnMode;
    private String username;    
    private boolean isGuest;
    
    
    public Mode(String username, boolean quizMode, boolean learnMode) {
        this.quizMode = quizMode;
        this.learnMode = learnMode;
        this.username = username;
        this.isGuest = false;
    }
    
    public Mode(boolean quizMode, boolean learnMode) {
        this.quizMode = quizMode;
        this.learnMode = learnMode;
        this.username = "guest";
        this.isGuest = true;
        
    }
    
    public boolean isGuest(){
        return isGuest;
    }
    
    public void setGuest(boolean isGuest){
        this.isGuest = isGuest;
    }    
   
    
    public String startMode() {
        return "No mode selected.";
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class Mode {
    private Quiz quiz;
    private Learn learn;
    private boolean quizMode;
    private boolean learnMode;
    private String username;
    
    
    public Mode(String username, boolean quizMode, boolean learnMode) {
        this.quizMode = quizMode;
        this.learnMode = learnMode;
        this.username = username;
    }
    
    public void setMode(String username) {
        if (quizMode) {
            this.quiz = new Quiz();
      } if (learnMode) {
          this.learn = new Learn(username);
        }
    }
    
    public String startMode() {
        return "No mode selected.";
    }
}

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
    
    public Mode(boolean quizMode, boolean learnMode) {
        this.quizMode = quizMode;
        this.learnMode = learnMode;
    }
    
    public void setMode() {
        if (quizMode) {
            this.quiz = new Quiz();
      } if (learnMode) {
          this.learn = new Learn();
        }
    }
    public void startMode() {
        if (quizMode) {
            System.out.println("Quiz Mode Activated!");
        } else if (learnMode) {
            System.out.println("Learn Mode Activated!");
        } else {
            System.out.println("No mode selected.");
        }
    }
}

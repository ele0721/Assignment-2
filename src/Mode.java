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
    
    public Mode(boolean quiz, boolean learn) {
        this.quiz = quiz;
        this.learn = learn;
    }
    
    public void setMode() {
        if (quiz = true) {
            new Quiz().setVisible(true);
            this.setVisible(false);
        } else {
            new Learn().setVisible(true);
            this.setVisible(false);
        }
    }

}

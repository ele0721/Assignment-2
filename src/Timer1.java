/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
import javax.swing.Timer;

public class Timer1 {
    private double timer;
    
//    timer = new Timer(1000, new ActionListener()) {
//        public void ActionPerformed (ActionEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
//        }
//    }
            
    public void countTimer() {
        int i = 20;
        i--;
        jLabel1.setText(String.valueOf(i));
    }
    
    public void setTimer(double timer) {
        this.timer = timer;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
import javax.swing.*;
import java.awt.event.*;

public class Timer1 {
   private Timer timer;
   private int timeLeft;
   private JLabel targetLabel;
   
   public Timer1(int seconds, JLabel label) {
       this.timeLeft = seconds;
       this.targetLabel = label;
       
       timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft >= 0) {
                    targetLabel.setText("" + timeLeft);
                    timeLeft--;
                } if(timeLeft <= 0) {
                    targetLabel.setText("Time's up");
                    timer.stop();
                }
            }
        });
   }
   
   public void start() {
       timer.start();
   }
   
   public void stop() {
       timer.stop();
   }
   
   public int getTime() {
       return timeLeft;
   }
   
   public void transitionTimer(JFrame currentFrame, JFrame nextFrame){
       Timer transitionTime = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextFrame.setVisible(true);
                currentFrame.setVisible(false);
            }
        });
        transitionTime.setRepeats(false);
        transitionTime.start();
   }
   
   public void feedbackTransitionTimer(JFrame currentFrame, JFrame nextFrame) {
        Timer transitionTime = new Timer(7000, new ActionListener() {
                @Override
            public void actionPerformed(ActionEvent e) {
                nextFrame.setVisible(true);
                currentFrame.setVisible(false);
            }
        });
        transitionTime.setRepeats(false);
        transitionTime.start();
       }
   

}

   
               

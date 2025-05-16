/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
//import javax.swing.Timer;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Timer1 {
//    private int countdown;
//    private int initialTime;
//    private Timer timer;
//    private javax.swing.JLabel jLabel1;
//    
//public Timer1() {
//        this.countdown = initialTime;
//        this.jLabel1 = jLabel1;
//        
//        // Create and configure the timer without a label
//        timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                countdown--;
//                updateDisplay();
//                
//                // Stop when countdown reaches zero
//                if (countdown <= 0) {
//                    timer.stop();
//                    if (jLabel1 != null) {
//                        jLabel1.setText("Time's up!");
//                    }
//                }
//            }
//        });
//    }
//    
//    public void start() {
//        timer.start();
//        updateDisplay();
//    }
//    
//    public void stop() {
//        timer.stop();
//    }
//    
//    public void reset(int seconds) {
//        countdown = seconds;
//        updateDisplay();
//    }
//    
//    public int getTime() {
//        return countdown;
//    }
//    
//    public void updateDisplay() {
//        if (jLabel1 != null) {
//            jLabel1.setText(String.valueOf(countdown));
//        }
//    }
//}

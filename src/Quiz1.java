import java.util.Scanner;
import java.io.IOException;
import java.io.File;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */

public class Quiz1 extends Mode {
    private boolean isTrue;
    private String feedback;
    private String news;
    private int score;

    
    public Quiz1() {
        super(true, false);
        this.isTrue = true;
        this.feedback = "";
        this.news = "";
        this.score = 0;
    }
    
    
    public String getNews() {
        return news;
    }
    
    
    public String getFeedback() {
        return feedback;
    }
    
    public boolean getReal() {
        return isTrue;
    }
    
    public void incrementScore() {
        score++;
    }
    
    public int getScore() {
        return score;
    }
    
    
    public boolean checkAnswer(boolean userAnswer) {
        if (userAnswer == isTrue) {
            incrementScore();
            return true;
        }
        return false;
    }
  

    
//    public String [] getInformation(String fileName) {
//        int lineCount = 0;
//        String [] information = new String[lineCount];
//        try {
//            Scanner scanner = new Scanner(new File(fileName));
//            while(scanner.hasNext()) {
//                scanner.nextLine();
//                lineCount++;
//            }
//            
//        } catch(IOException e) {
//            System.out.println("Error!");
//        }
//    
//        try {
//            Scanner scanner = new Scanner(new File(fileName));
//            int i = 0;
//            while (scanner.hasNext()) {
//                String line = scanner.nextLine();
//                String [] data = line.split(",");
//             } 
//                     
//        } catch(IOException e) {
//            System.out.println("Error" + e);
//        }   
//        return information;
//    
//    }
    
}


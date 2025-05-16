/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */

//import java.util.Scanner;
//import java.io.IOException;
//import java.io.File;


public class Quiz1 {
    private String [] questions;
    private boolean isTrue;
    private String feedback;
    private String news;
    private int score;

    
    public Quiz1() {
        this.questions = questions;
        this.isTrue = true;
        this.feedback = "";
        this.news = "";
        this.score = 0;
    }
    
    
    public String getNews() {
        return news;
    }
    
    public String [] getQuestions() {
        return questions;
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
    
    
    public boolean checkAnswer(boolean userAnswer) {
        if(userAnswer = true) {
            incrementScore();
            return true;
        }
        return false;
    }
  
}
    
//    public String[] getInformation(String fileName) {

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
//    
//    }


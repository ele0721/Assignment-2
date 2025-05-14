
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 345700744
 */
public class Learn {
    private String[] informations;
    
    public Learn(String topic){
        
    }
    
    public String [] getInformation(String fileName){
        int lineCount = 0;
        String [] information = new String[lineCount];
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                scanner.nextLine();
                lineCount++;
            }
        } catch(IOException e){
            System.out.println("Error");
        }
        
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String [] info = data.split(",");
            }
        } catch(IOException e){
            System.out.println("Error");
        }
        return information;
    }
   
}


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
public class Learn extends Mode{
    private String[] informations;
    private String[] topics;
    
    public Learn(){
         super(false, true);
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
            int i = 0;
            String [] info = new String[lineCount];
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                info[i] = data;
                System.out.println(info[i]);
                i++;
                
            }
        } catch(IOException e){
            System.out.println("Error");
        }
        return information;
    }
   
}



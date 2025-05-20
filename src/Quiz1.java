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
    private String [] sections;
    private int index = 0;

    
    public Quiz1() {
        super(true, false);
        this.index = 0;
    }
   
    
    public String [] getInformation(String fileName) {
        int lineCount = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                if(line.trim().equals(",")) {
                        lineCount++;
                }
            } 
            scanner.close();
        } catch(IOException e) {
            System.out.println("Error");
        }
        try {
            int count = 0;
            sections = new String[lineCount + 1];
            String currentSection = "";
            Scanner scanner1 = new Scanner(new File(fileName));
            while(scanner1.hasNext()) {
                String line1 = scanner1.nextLine();
                if(line1.trim().equals(",")) {
                    if(!currentSection.isEmpty()) {
                        sections[index++] = currentSection.trim();
                        index++;
                        currentSection = "";
                    }
                } else {
                    currentSection += line1 + "\n";
                }
            }
            if(!currentSection.isEmpty()) {
                sections[index] = currentSection.trim();
            }
            scanner1.close();
        } catch(IOException e) {
            System.out.println("Error");
        }
        return sections;
    }
    
    public String displaySection() {
        if(sections != null && index < sections.length) {
            return sections[index++];
        } else {
            return "Error";
        }
    }
    
}
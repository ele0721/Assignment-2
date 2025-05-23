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
    private int index;
    private boolean initialized = false;

    
     public Quiz1(String username) {
        super(username, true, false);
        this.index = 0;
     }
     
         public void nextSection() {
        index++;
    }
    
    public String [] getInformation(String fileName) {
        int lineCount = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            if(scanner.hasNextLine()) {
                scanner.nextLine();
            }
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
        int count = 0;
        sections = new String[lineCount + 1];
        String currentSection = "";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                if(line.trim().equals(",")) {
                    if(!currentSection.isEmpty()) {
                        sections[count++] = currentSection;
                        currentSection = "";
                    }
                } else {
                    currentSection += line.trim() + "\n";
                }
            }
            scanner.close();
            if(!currentSection.isEmpty()) {
                sections[count++] = currentSection;
            }
            initialized = true;
        } catch(IOException e) {
            System.out.println("Error");
        }
        return sections;
    }
    
    public String displaySection() {
        if(!initialized || sections == null) {
            return "Error!";
        }
        if(index < sections.length) {
            String section = sections[index];
            return section;
        } else {
            return "Error!";
        }
    }
    
}


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
    private String[] sections;
    private int index;
    private Bookmark bookmark;
    
    public Learn(){
         super(false, true);
         this.index = 0;
         this.bookmark = new Bookmark();
    }
    
    public String [] loadInformation(String fileName){
        int lineCount = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(line.trim().equals("///")){
                lineCount++;
                }
            }
            scanner.close();
        } catch(IOException e){
            System.out.println("Error");
        }        
        int count = 0;
        sections = new String[lineCount + 1];
        String currentSection = "";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.trim().equals("///")) {
                    if (!currentSection.isEmpty()) {
                        sections[count++] = currentSection;
                        currentSection = "";
                    }
                } else {
                    currentSection += line.trim() + "\n";
                }
            }
            scanner.close();
                if (!currentSection.isEmpty()) {
                sections[count++] = currentSection;
            }
        } catch(IOException e){
            System.out.println("Error");
        }
        return sections;
    }
   
    public String getNextSection() {
        if (sections != null && index < sections.length) {
            return sections[index++];
        } else {
            index = 0;
            return "No more sections!";
        }
    }
    
    public int getIndex() {
        return index - 1;
    }
    
    public void setIndex(int newIndex) {
        if (sections == null || sections.length == 0) {
            return; 
        }
        if (newIndex >= 0 && newIndex < sections.length) {
            index = newIndex;
        } else {
            System.out.println("Invalid index.");
        }
    }
    
    public String getSection(int index) {
        return sections[index];
    }
    
    public void addBookmark(String name) {
        bookmark.saveBookmark(name, getIndex());
    }
    
    public void goToBookmark(String name) {
        int bookmarkedIndex = bookmark.getBookmarkIndex(name);
        if (bookmarkedIndex != -1) {
            setIndex(bookmarkedIndex);
        } else {
            System.out.println("Bookmark not found.");
        }
    }
     
    public void removeBookmark(String name) {
        bookmark.removeBookmark(name);
    }
    
    @Override    
    public void startMode() {
        System.out.println("Starting Learn Mode...");
    }

}



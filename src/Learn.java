import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author 345700744
 */
public class Learn extends Mode{
    private String[] sections;
    private int index;
    private Bookmark bookmark;
    
    public Learn(String username){
         super(username, false, true);
         this.index = 0;
         this.bookmark = new Bookmark(username);
    }
    
    /**
     * Loads learning sections from a specified file.
     * @param fileName The name of the file containing learning sections
     * @return An array of strings where each element represents a section
     */
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
            System.out.println("Error loading information: " + e.getMessage());
        }
        sections = new String[lineCount + 1];        
        int count = 0;
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
            System.out.println("Error reading file.");
        }
        return sections;
    }
    
    /**
     * Calculates and returns the user's learning progress as a percentage.
     * @return Progress percentage (0-100)
     */
    public int getProgressPercentage() {
        if (sections == null || sections.length == 0) return 0;
        return (int) (((double) index / sections.length) * 100);
    }

    /**
     * Retrieves the next section in the learning mode.
     * @return The next section's content or a message if finished
     */
    public String getNextSection() {
        if (sections != null && index < sections.length) {
            return sections[index++];
        } else {
            index = 0;
            return "No more sections!";
        }
    }
    
    /**
     * Gets the current section index.
     * @return The current index
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * Sets the section index to a new value.
     * @param newIndex The new index value
     */
    public void setIndex(int newIndex) {
       index = newIndex;
    }
    
    /**
     * Retrieves the content of a specific section based on its index.
     * @param index The index of the section to retrieve
     * @return The section's content
     */
    public String getSection(int index) {
        return sections[index];
    }
    
    /**
     * Saves a bookmark at the current index with a given name.
     * @param name The name of the bookmark
     */
    public void addBookmark(String name) {
        bookmark.saveBookmark(name, getIndex());
    }
    
    /**
     * Navigates to a bookmarked section by its name.
     * @param name The name of the bookmark to navigate to
     */
    public void goToBookmark(String name) {
        for (String[] entry : bookmark.loadBookmarks()) {

            if (entry[0].equals(name)) {
                setIndex(Integer.parseInt(entry[1]));
                return;
            }
        }
    }
    
    /**
     * Removes a saved bookmark by its name.
     * @param name The name of the bookmark to remove
     */
    public void removeBookmark(String name) {
        bookmark.removeBookmark(name);
    }
    
    /**
     * Starts the Learn mode and returns a message indicating its activation.
     * @return A message indicating Learn mode has started
     */
    @Override    
    public String startMode() {
        return "Starting Learn Mode...";
    }
}



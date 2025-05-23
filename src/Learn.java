import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Helen
 */
public class Learn extends Mode{
    private String[] sections;
    private int index;
    private Bookmark bookmark;

    // Constructor
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
        int lineCount = 0; // Count the number of sections
        try {
            Scanner scanner = new Scanner(new File(fileName)); // Open scanner to read the file
            // Read each lines to determine the number of sections
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(line.trim().equals("///")){
                lineCount++; // Increase counter
                }
            }
            scanner.close();
        } catch(IOException e){
            System.out.println("Error loading information: " + e.getMessage());
        }
        sections = new String[lineCount + 1];  // Initialize the array with the correct number of sections     
        int count = 0;  // Counter to track the sections
        String currentSection = ""; // Set currentSection empty
        try {
            // Read file again to store sections
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.trim().equals("///")) {
                    // If current section is not empty, store section
                    if (!currentSection.isEmpty()) {
                        sections[count++] = currentSection;
                        currentSection = ""; // Reset for the next section
                    }
                } else {
                    currentSection += line.trim() + "\n";  // Append section content
                }
            }
            scanner.close();
                if (!currentSection.isEmpty()) {
                sections[count++] = currentSection; // Store the last section if not empty
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
        if (sections == null || sections.length == 0) { // Check if section is valid
            return 0;
        } else {
        return (int) (((double) index / sections.length) * 100); // Calculate progress percentage
        }
    }

    /**
     * Retrieves the next section in the learning mode.
     * @return The next section's content or a message if finished
     */
    public String getNextSection() {
        if (sections != null && index < sections.length) { // Check if section is valid
            return sections[index++]; // Return next section and increase index by one
        } else {
            index = 0; // Reset index
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
        for (String[] entry : bookmark.loadBookmarks()) { // Loop through saved bookmarks
            // Find matching bookmark and update index
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



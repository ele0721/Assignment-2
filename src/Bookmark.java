import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author Helen
 */
public class Bookmark {
    private String bookmarkFile;

    // Constructor
    public Bookmark(String username) {
        this.bookmarkFile = "bookmark_" + username + ".txt";
        File file = new File(bookmarkFile);
    }

    /**
     * Saves a bookmark with a name and index to the user's bookmark file.
     * @param name The name of the bookmark
     * @param index The section index
     */
    public void saveBookmark(String name, int index) {
        try {
            FileWriter writer = new FileWriter(bookmarkFile, true); // Open filewriter to append to bookmarkFile 
            writer.write(name + "," + index + "\n"); // Write bookmark name and index
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving bookmark: " + e.getMessage()); // Display message if error occurs
        }
    }

    /**
     * Removes a bookmark by name from the user's bookmark file.
     * @param name The name of the bookmark to remove
     */
    public void removeBookmark(String name) {
        List<String[]> bookmarks = loadBookmarks(); // Load current bookmarks
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(bookmarkFile)); // Open file to write
            for (String[] entry : bookmarks) { // Loop through bookmarks
                if (!entry[0].equals(name)) { // Skip the bookmark to be removed
                    writer.println(entry[0] + "," + entry[1]); // Write remaining bookmarks
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error removing bookmark: " + e.getMessage()); // Display message if error occurs
        }
    }

    /**
     * Loads all bookmarks from the user's bookmark file.
     * @return A list of bookmarks
     */
     public List<String[]> loadBookmarks() { // Load current bookmarks
        List<String[]> bookmarks = new ArrayList<>(); // Initialize bookmark list
        try {
            Scanner scanner = new Scanner(new File(bookmarkFile)); // Open bookmark file
            // Read all bookmarks and split bookmark name and index
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                bookmarks.add(line.split(",")); 
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("No saved bookmarks found."); // Display message if error occurs
        }
        return bookmarks;
    }
}

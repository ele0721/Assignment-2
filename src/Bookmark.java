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
 *
 * @author Helen
 */
public class Bookmark {
        private String bookmarkFile;


    public Bookmark(String username) {
        this.bookmarkFile = "bookmark_" + username + ".txt";
         File file = new File(bookmarkFile);
    }

    public void saveBookmark(String name, int index) {
        try {
            FileWriter writer = new FileWriter(bookmarkFile, true);         
            writer.write(name + "," + index + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving bookmark: " + e.getMessage());
        }
    }

    public void removeBookmark(String name) {
        List<String[]> bookmarks = loadBookmarks();
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(bookmarkFile));
            for (String[] entry : bookmarks) {
                if (!entry[0].equals(name)) {
                    writer.println(entry[0] + "," + entry[1]);
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error removing bookmark: " + e.getMessage());
        }
    }

     public List<String[]> loadBookmarks() {
        List<String[]> bookmarks = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(bookmarkFile));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                bookmarks.add(line.split(",")); 
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("No saved bookmarks found.");
        }
        return bookmarks;
        
    }
}

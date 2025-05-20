
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 345700744
 */
public class Bookmark {
    private String[] bookmarkNames;
    private int[] bookmarkIndexes;
    private int count;
    private static final int MAX_BOOKMARKS = 10;
    private static final String BOOKMARK_FILE = "bookmarks.txt";

    public Bookmark() {
        bookmarkNames = new String[MAX_BOOKMARKS];
        bookmarkIndexes = new int[MAX_BOOKMARKS];
        count = 0;
        loadBookmarks();
    }

    public void saveBookmark(String name, int sectionIndex) {
        if (count < MAX_BOOKMARKS) {
            bookmarkNames[count] = name;
            bookmarkIndexes[count] = sectionIndex;
            count++;
            writeToFile();
        } else {
            System.out.println("Bookmark limit reached.");
        }
    }

    public void removeBookmark(String name) {
        int index = findBookmarkIndex(name);
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                bookmarkNames[i] = bookmarkNames[i + 1];
                bookmarkIndexes[i] = bookmarkIndexes[i + 1];
            }
            count--; 
            writeToFile();
        } else {
            System.out.println("Bookmark not found.");
        }
    }

    public String[] getBookmarkNames() {
    String[] result = new String[count]; 
    for (int i = 0; i < count; i++) {
        result[i] = bookmarkNames[i];
    }
    return result;
}

    private int findBookmarkIndex(String name) {
        for (int i = 0; i < count; i++) {
            if (bookmarkNames[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void loadBookmarks() {
        count = 0;
        bookmarkNames = new String[MAX_BOOKMARKS];
        bookmarkIndexes = new int[MAX_BOOKMARKS]; 

        try {
            Scanner scanner = new Scanner(new File(BOOKMARK_FILE));
            while (scanner.hasNext() && count < MAX_BOOKMARKS) {
                String name = scanner.nextLine();
                int index = Integer.parseInt(scanner.nextLine());

                if (index >= 0) {
                    bookmarkNames[count] = name;
                    bookmarkIndexes[count] = index;
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("No saved bookmarks found.");
        }
    }


    public int getBookmarkIndex(String name) {
        name = name.trim();
        for (int i = 0; i < count; i++) {
            if (bookmarkNames[i].equals(name)) {
                return bookmarkIndexes[i];
            }
        }
        return -1; 
    }

    private void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKMARK_FILE))) {
            for (int i = 0; i < count; i++) {
                writer.println(bookmarkNames[i]);
                writer.println(bookmarkIndexes[i]);
            }
        } catch (IOException e) {
            System.out.println("Error saving bookmarks.");
        }
    }  
}

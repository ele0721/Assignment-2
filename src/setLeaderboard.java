import java.io.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
public class setLeaderboard {
    private static final String LEADERBOARD_FILE = "leaderboard.txt";
    private List<LeaderboardEntry> entries;
    private static final setLeaderboard instance = new setLeaderboard();
            
   public static class LeaderboardEntry {
       private String username;
       private int score;
       
       public LeaderboardEntry(String username, int score) {
           this.username = username;
           this.score = score;
       }
       
       public String getUsername() {
           return username;
       }
       
       public int getScore() {
           return score;
       }
       
       public String toFileString() {
           return username + "," + score;
       }

    } 
   
   private setLeaderboard() {
       this.entries = new ArrayList<>();
       loadLeaderboard();
   }
   
   public static setLeaderboard getInstance() {
       return instance;
   }
   
   public void addScore(String username, int score) {
       LeaderboardEntry entry =  new LeaderboardEntry(username, score);
       entries.add(entry);
       sortByScore();
       saveLeaderboard();
   }
   
   private void sortByScore() {
       entries.sort((e1, e2) -> Integer.compare(e2.getScore(), e1.getScore()));
   }
   
   private void loadLeaderboard() {
       try {
           File file = new File(LEADERBOARD_FILE);
           if (!file.exists()) {
               file.createNewFile();
               return;
           }
           
           Scanner scanner = new Scanner(file);
           while (scanner.hasNextLine()) {
               String line = scanner.nextLine().trim();
               if(!line.isEmpty()) {
                   String [] parts = line.split(",");
                   if(parts.length >= 2) {
                       String username = parts[0].trim();
                       int score = Integer.parseInt(parts[1].trim());
                       entries.add(new LeaderboardEntry(username, score));
                   }
               }
           }
           scanner.close();
           sortByScore();
       } catch(IOException e) {
           System.out.println("Error" + e);
           
       }
   }
   
   public void saveLeaderboard() {
       try {
           PrintWriter writer = new PrintWriter(new FileWriter(LEADERBOARD_FILE));
           for (LeaderboardEntry entry: entries) {
               writer.println(entry.toFileString());
           }
           writer.close();
       } catch(IOException e) {
           System.out.println("Error" + e);
       }
   }
   
   public List<LeaderboardEntry> getAllentries() {
       return new ArrayList<>(entries);
   }
   
   public List<LeaderboardEntry> getUserScores(String username) {
       List<LeaderboardEntry> userScores = new ArrayList<>();
       for (LeaderboardEntry entry: entries) {
           if(entry.getUsername().equals(username)) {
               userScores.add(entry);
           }
       }
       
       userScores.sort((e1, e2) -> Integer.compare(e2.getScore(), e1.getScore()));
       return userScores;
   }
}

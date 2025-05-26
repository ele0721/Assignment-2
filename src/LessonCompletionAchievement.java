/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Helen
 */
public class LessonCompletionAchievement extends Achievement {
    
    // Constructor
    public LessonCompletionAchievement() {
        super("Completed all lessons!");
    }
    
    @Override
    /**
     * Unlocks the achievement and returns a message.
     * @return A message showing the achievement unlocked
     */
    public String unlockAchievement() {
        return "📖 Achievement Unlocked: Completed all lessons!";
    }
}

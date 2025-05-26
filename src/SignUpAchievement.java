/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Helen
 */
public class SignUpAchievement extends Achievement {
    
    // Constructor
    public SignUpAchievement() {
        super("Signed up successfully!");
    }
    
    @Override
    /**
     * Unlocks the achievement and returns a message.
     * @return A message showing the achievement unlocked
     */
    public String unlockAchievement() {
        return "🎉 Achievement Unlocked: Signed up successfully!";
    }
}

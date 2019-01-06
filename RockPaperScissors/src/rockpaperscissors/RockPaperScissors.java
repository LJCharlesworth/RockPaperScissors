package rockpaperscissors;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RockPaperScissors {
    
    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();
    
    public static int[] score = {0, 0};
    public static boolean loop = false;
    public static String[] options = {"rock", "paper", "scissors"};
    public static int[] selection = new int[2];
    
    public static void printScore() {
        System.out.println("Score [player, AI]: " + Arrays.toString(score));
    }
    
    public static int selection() {
        
        int check;
        int playerChoice = 0;
        
        do{
            
            check = 0;
        
            //Print options to chose from
            System.out.println("Select: " + Arrays.toString(options));
            String userInput = input.next();

            //Convert player input to a int to be returned
            if (userInput.equalsIgnoreCase(options[0])){
                playerChoice = 0;
            }else{
                if (userInput.equalsIgnoreCase(options[1])){
                    playerChoice = 1;
                }else{
                    if (userInput.equalsIgnoreCase(options[2])){
                        playerChoice = 2;
                    }else{
                        System.out.println("Invalid input");
                        check = 1;
                    }
                }
            }
            
        }while(check == 1);
        
        return playerChoice;
        
    }

    public static void judge() {
        
        //Use a switch to chose which if statement to use to decde who won, then change scores
        switch(selection[0]){
            
            case 0:
                if(selection[1] == 0){
                    System.out.println("Draw!");
                }else{
                    if(selection[1] == 1){
                        System.out.println("You lose!");
                        score[1] += 1;
                    }else{
                        if(selection[1] == 2){
                            System.out.println("You win!");
                            score[0] += 1;
                        }
                    }
                }
                break;
                
            case 1:
                if(selection[1] == 1){
                    System.out.println("Draw!");
                }else{
                    if(selection[1] == 2){
                        System.out.println("You lose!");
                        score[1] += 1;
                    }else{
                        if(selection[1] == 0){
                            System.out.println("You win!");
                            score[0] += 1;
                        }
                    }
                }
                break;
                
            case 2:
                if(selection[1] == 2){
                    System.out.println("Draw!");
                }else{
                    if(selection[1] == 0){
                        System.out.println("You lose!");
                        score[1] += 1;
                    }else{
                        if(selection[1] == 1){
                            System.out.println("You win!");
                            score[0] += 1;
                        }
                    }
                }
                break;
            
        }
        
    }
    
    public static boolean again() {
        
        int check;
        boolean again = false;
        
        do{
            
            check = 0;
            
            //Open poup for user to make decision
            JFrame frame = new JFrame();
            frame.setVisible(true);
            String message = "Play again";
            int answer = JOptionPane.showConfirmDialog(frame, message);
            if (answer == JOptionPane.YES_OPTION) {
                // User clicked YES.
                check = 1;
                again = true;
            } else if (answer == JOptionPane.NO_OPTION) {
                // User clicked NO.
                check = 2;
                again = false;
            }else{
                System.out.println("There has been an error, reselect your option");
            }
        
            frame.setVisible(false);
            
        }while(check  == 0);
        
        return again;
        
    }
    
    public static void main(String[] args) {
        
        do{
            
            //Print score
            printScore();
           
            //Get player and AI chosen play
            selection[0] = selection();
            selection[1] = rand.nextInt(options.length);
            
            //Decide who won
            judge();
            
            //Decide to play again
            loop = again();
            
        }while (loop == true);
        
        //Print final score then exit
        printScore();
        System.exit(0);
        
    }
    
}
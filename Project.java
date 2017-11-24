/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Project {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Greetings agent. Please enter your name: ");
        String name = kb.nextLine();
        int mode = ModeChoose(name); // which mode the user chose
        if (mode == 1) { // when the user chose adding and subtracting
            AddSub(name); // calling the addition and subtraction level
        }
    }

    public static int ModeChoose(String name) { // Entering the username, and choosing which mode to play
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to The Incredible Spiez Agent " + name + ". Let's begin!\n");
        System.out.println("Mission Update:");
        System.out.print("Syndrome (aka Buddy Pine) is sending out encrypted messages.");
        System.out.println(" We need you to decode them in order to find and stop him.");
        System.out.print("Please choose a mode. Enter 1 for addition and subtraction, 2 for multiplication");
        System.out.print(" and division, or 3 for BEDMAS.\n -> ");
        int mode = kb.nextInt();
        return mode;
    }
    
    public static String Location(int roundNum){ // this method randomlly chooses locations for each of the 4 rounds
        String location = "";
        Random rand = new Random();
        int randPlace = rand.nextInt(5); // variable for which location is randomly selected
        if (roundNum==1) { // locations for first round
            if (randPlace == 0) {
                location = "Moscow";
            }
            if (randPlace == 1) { 
                location = "Shanghai";
            }   
            if (randPlace == 2) {
                location = "London";
            }
            if (randPlace == 3) {
                location = "Copenhagen";
            }
            if (randPlace == 4) {
                location = "Washington";
            }
        }
        else if (roundNum==2) { // locations for second round
            if (randPlace == 0) {
                location = "warehouse";
            }
            if (randPlace == 1) { 
                location = "embassy";
            }
            if (randPlace == 2) {
                location = "skyscraper";
            }
            if (randPlace == 3) {
               location = "parliment";
            }
            if (randPlace == 4) {
                location = "airport";
            }
        }
        else if (roundNum==3) { // locations for third round
            if (randPlace == 0) {
                location = "cabinets";
            }
            if (randPlace == 1) { 
                location = "basement";
            }
            if (randPlace == 2) {
                location = "cellar";
            }
            if (randPlace == 3) {
               location = "elevator";
            }
            if (randPlace == 4) {
                location = "bookshelf";
            }
        }
        else if (roundNum==4) { // locations for fourth round
            if (randPlace == 0) {
                location = "dossier";
            }
            if (randPlace == 1) { 
                location = "USB drive";
            }
            if (randPlace == 2) {
                location = "top secret document";
            }
            if (randPlace == 3) {
               location = "memory chip";
            }
            if (randPlace == 4) {
                location = "hard drive";
            }
        }
        return location;
        
    }
    
    
    public static void AddSub(String userName) {
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.println("\nDecode the secret message below!\n");
        boolean keepPlaying = true; // keeps track if the user still wats to play
        int roundProgress = 1; // changes the difficulty as more words are found
        int roundNum = 1; //  counter for what round is the user on
        int num1, num2, addSub; // addSub decides if question will be addition or subtraction
        while (keepPlaying==true && roundNum <= 3) { // within the three rounds, and when the user doesnt want to quit
            String location = Location(roundNum); // String location is the retunred location from the method: Location 
            for (int i=0; i<location.length(); i++) {
                num1 = rand.nextInt(10 * roundProgress); // num randomly chosen. 1 didget if round 1, 2 didget if round 2, etc
                num2 = rand.nextInt(10 * roundProgress); // num randomly chosen. 1 didget if round 1, 2 didget if round 2, etc
                addSub = rand.nextInt(2); //addSub can either be 0 or 1, for adding or subtracting
                if (addSub == 1) { // if it is subtraction
                    while (num1 - num2 < 0) { // ensuring that differences will all be positive
                        num1 = rand.nextInt(10 * roundProgress); // new num1 randomly chosen
                        num2 = rand.nextInt(10 * roundProgress); // new num2 randomly chosen  
                    }
                }
                boolean correct = false; // counter for if the question was answered correctly
                while (correct==false) {
                    if (addSub == 0) { // this question is addition
                        System.out.print(num1 + " + " + num2 + " = ");
                        int answer = kb.nextInt();
                        if (answer == num1+num2 && i == location.length() - 1) { // when the last letter is found
                            System.out.print(i+1 + "/" + location.length() + " of the message decoded! ");
                            System.out.print("You found the letter " + location.charAt(i));
                            System.out.println(". You found the last one!\n");
                            correct = true; // the math question was solved correctly
                    }
                        else if (answer == num1+num2 && i >= location.length() - 3) { // when the word is almost solved
                            System.out.print(i+1 + "/" + location.length() + " of the job done! ");
                            System.out.print("You found the letter " + location.charAt(i));
                            System.out.println(". We're really close now!\n");
                            correct = true; // the math question was solved correctly
                        }
                        else if (answer == num1+num2) { // when a letter is found, but word not almost solved
                            System.out.print(i+1 + "/" + location.length() + " parts done! ");
                            System.out.print("You found the letter " + location.charAt(i));
                            System.out.println(". Good work! On to the next one:\n");
                            correct = true; // the math question was solved correctly
                        }
                        else { // question was answered incorrectly
                            System.out.println("Darn it, thats the wrong answer. Give it another try agent!");
                        }
                
                    }
                    else { // this question is subtraction
                        System.out.print(num1 + " - " + num2 + " = ");
                        int answer = kb.nextInt();
                        if (answer == num1-num2 && i == location.length() - 1) { // when the last letter is found
                            System.out.print(i+1 + "/" + location.length() + " of the message decoded! ");
                            System.out.print("You found the letter " + location.charAt(i));
                            System.out.println(". You found the last one!\n");
                            correct = true; // the math question was solved correctly
                    }
                        else if (answer == num1-num2 && i >= location.length() - 3) { // when the word is almost solved
                            System.out.print(i+1 + "/" + location.length() + " of the job done! ");
                            System.out.print("You found the letter " + location.charAt(i));
                            System.out.println(". We're really close now!\n");
                            correct = true; // the math question was solved correctly
                        }
                        else if (answer == num1-num2) { // when a letter is found, but word not almost solved
                            System.out.print(i+1 + "/" + location.length() + " parts done! ");
                            System.out.print("You found the letter " + location.charAt(i));
                            System.out.println(". Good work! On to the next one:\n");
                            correct = true; // the math question was solved correctly
                        }
                        else { // question was answered incorrectly
                            System.out.println("Darn it, thats the wrong answer. Give it another try agent!");
                        }
                    }
                }
            }
            System.out.println("Agent " + userName + ", you decoded the word " + location +"!");
            if (roundNum == 1) { // when its the first round
                System.out.print("Should we go to " + location);
                System.out.print("? (type \"yes\" to move to level 2, \"no\" to quit): ");
                String userContinue = kb.next();
                System.out.println();
                if (userContinue.equalsIgnoreCase("No")) { // if they do not want to keep playing
                    keepPlaying = false; // keepPlaying counter changes to false
                }
            }
            else if (roundNum ==2) { // when its the second round
                System.out.print("Should we go into the " + location); 
                System.out.print("? (type \"yes\" to move to level 3, \"no\" to quit): ");
                String userContinue = kb.next();
                System.out.println();
                if (userContinue.equalsIgnoreCase("No")) { // if they do not want to keep playing
                    keepPlaying = false; // keepPlaying counter changes to false
                }
            }
            else { // when its third round
                System.out.print("Should we investigate the " + location);
                System.out.print("? (type \"yes\" to move to level 4, \"no\" to quit): ");
                String userContinue = kb.next();
                System.out.println();
                if (userContinue.equalsIgnoreCase("No")) { // if they do not want to keep playing
                    keepPlaying = false; // keepPlaying counter changes to false
                }
            }
            roundNum ++; // round goes up to next round
            roundProgress *= 10; // next round uses 1 more didget with addition and subtraction
        }
        if (keepPlaying == false) { // messages displayed if the user quits after a round
            System.out.println("Thanks for your help. Please try and assist us again soon, as Syndrome is still on the loose.");
        }
        else if (roundNum == 4) { // on the fourth and final round
            String location = Location(roundNum); // String location is the retunred location from the method: Location 
            System.out.println("We are almost done agent! We just need to decode one more peice of information!");
            num1 = rand.nextInt(10 * roundProgress); //random 4 didget number
            num2 = rand.nextInt(1 * roundProgress); // random 3 didget number
            boolean correct = false; // counter for if the question was answered correctly
            while (correct==false) {
                System.out.print("can you solve the last question? " + num1 + " + " + num2 + " = ");
                int answer = kb.nextInt();
                if (answer == num1+num2) { // when answer is correct
                    System.out.println("You found the word " + location);
                    correct = true; // the question was answered correctly
                }
                else { // when answer was incorrect
                    System.out.println("Darn it, thats the wrong answer. Give it another try agent!");
                }
            }
            System.out.print("Should we take the " + location);
            System.out.print("? (type \"yes\" to take it, \"no\" to quit): ");
            String userContinue = kb.next();
            if (userContinue.equalsIgnoreCase("No")) { // if they dont want to keep playing
                keepPlaying = false; // keepPlaying counter changes to false
            }
            if (keepPlaying == true) { // if user completes addition and subtraction mode
            String finalMsg = "Congratulations agent " + userName + "! Inside of the " + location + " that you discovered," +
            " we were able to figure out Syndrome's evil plans! Thank you for your help agent, your" +
            " assistance was invaluable in saving the world!";
            JOptionPane.showMessageDialog(null,finalMsg);
            }
        }
        if (keepPlaying == false && roundNum == 4) { // messages displayed if the user quits after round 4
            System.out.println("Thanks for your help. Please try and assist us again soon. We were so close!");
    
        }
    }
}

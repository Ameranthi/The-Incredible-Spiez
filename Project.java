/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;
import java.util.Scanner;
public class Project {
    public static void main(String[] args) {
        Easy();
    }
    
    
    public static String Location(){
        int randPlace = 5; // variable for which location is randomly selected
        String location = "";
        Random rand = new Random();
        randPlace = rand.nextInt(5);
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
            location = "catacombs";
        }
        return location;
    }
            
    

    public static void Easy() {
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.println("Decode the secret message below!\n");
        String location = Location(); // location is the retunred location from the Location method
        boolean keepPlaying = true; // keeps track if the user still wats to play
        int roundProgress = 1; // changes the difficulty as more words are found
        //while (keepPlaying=true) {
        for (int i=0; i<location.length(); i++) {
            int num1, num2, addSub; // addSub decides if question will be addition or subtraction
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
            addSub = rand.nextInt(1); //addSub can either be 0 or 1, for adding or subtracting
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
        System.out.println("You decoded the word " + location +"!");
        //}

    }
}

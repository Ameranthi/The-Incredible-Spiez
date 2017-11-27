/*
 * I added all of our parts together the best I could. I also tried to get the indentation correct.
   We should look over the code together tonight, and then make sure the report is done well.
    ~ Nick
 */

/* This program is a children's math game. It has a spy theme. The program asks for the user's name, and then asks which
   mode they'd like to play. The modes are addition/subtraction, multiplication/division, and fraction comparisson. 

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
        if (mode == 1) { // when user chooses adding and subtracting level
            AddSub(name); 
        }
        else if (mode==2) { // when user wants Multiplication/division level
            multDiv(name);
        }
        else if (mode == 3) { // when user wants fraction comparison level
            fraction(name);
        }
        else { // if user inputs a number that doesnt correspind to a mode
            System.out.println("That isn't a mode agent " + name + ". Please play again with a valid mode.");
        }
    }

    public static int ModeChoose(String name) { // Entering the username, and choosing which mode to play
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to The Incredible Spiez Agent " + name + ". Let's begin!\n");
        System.out.println("Mission Update:");
        System.out.print("Syndrome (aka Buddy Pine) is sending out encrypted messages.");
        System.out.println(" We need you to decode them in order to find and stop him.");
        System.out.print("Please choose a mode. Enter 1 for addition and subtraction, 2 for multiplication");
        System.out.print(" and division, or 3 for fractions.\n -> ");
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
    
    public static void multDiv (String userName) {
      Random rand = new Random();
      Scanner kb = new Scanner(System.in);
      System.out.println("\nDecode the secret message below!\n");
      boolean keepPlaying = true; // keeps track if the user still wats to play
      int roundProgress = 1; // changes the difficulty as more words are found
      int roundNum = 1; //  counter for what round is the user on
      int num1, num2, multDiv; // MultDiv decides if question will be multiplication or division
   
      while (keepPlaying==true && roundNum <= 3) { // within the three rounds, and when the user doesnt want to quit
         String location = Location(roundNum); // String location is the retunred location from the method: Location 
         
         for (int i=0; i<location.length(); i++) {
            num1 = rand.nextInt(10 * roundProgress); // num randomly chosen. 1 digit if round 1, 2 digit if round 2, etc
            num2 = rand.nextInt(10 * roundProgress); // num randomly chosen. 1 digit if round 1, 2 digit if round 2, etc
            multDiv = rand.nextInt(2); //multDiv can either be 0 or 1, for multiplying or dividing
            if (multDiv == 0) { // if it is division
               
               while (num2 == 0) { // ensuring that you never divide by 0
                  num2 = rand.nextInt(10 * roundProgress); // new num2 randomly chosen  
               }
            }
            boolean correct = false; // counter for if the question was answered correctly
            
            while (correct==false) {
               if (multDiv == 1) { // this question is multiplication
                  System.out.print(num1 + " * " + num2 + " = ");
                  double answer = kb.nextDouble();
                  if (answer == num1*num2 && i == location.length() - 1) { // when the last letter is found
                     System.out.print(i+1 + "/" + location.length() + " of the message decoded! ");
                     System.out.print("You found the letter " + location.charAt(i));
                     System.out.println(". You found the last one!\n");
                     correct = true; // the math question was solved correctly
                  }
                  else if (answer == num1*num2 && i >= location.length() - 3) { // when the word is almost solved
                     System.out.print(i+1 + "/" + location.length() + " of the job done! ");
                     System.out.print("You found the letter " + location.charAt(i));
                     System.out.println(". We're really close now!\n");
                     correct = true; // the math question was solved correctly
                  }
                  else if (answer == num1*num2) { // when a letter is found, but word not almost solved
                     System.out.print(i+1 + "/" + location.length() + " parts done! ");
                     System.out.print("You found the letter " + location.charAt(i));
                     System.out.println(". Good work! On to the next one:\n");
                     correct = true; // the math question was solved correctly
                  }
                  else { // question was answered incorrectly
                     System.out.println("Darn it, thats the wrong answer. Give it another try agent!");
                  }
               
               }
               else { // this question is for Division
                  System.out.println(num1 + " / " + num2 + " = ");
                  System.out.println("Remeber to put two decimal places when dividing");
                  double correctAnswer=(double)num1/(double)num2;
                  String correctRounded=String.format("%6.2f", correctAnswer); //rounds to two decimal places
                  double answer = kb.nextDouble();
                 
                  String rounded = String.format("%6.2f", answer); //round to two decimal places
                  //System.out.println(rounded + " " + correctRounded); // commented out occasionally for testing
                  
                  if (rounded.equals(correctRounded)) {          
                     if (i == location.length() - 1) { // when the last letter is found
                        System.out.print(i+1 + "/" + location.length() + " of the message decoded! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". You found the last one!\n");
                        correct = true; // the math question was solved correctly
                     }
                     else if (i >= location.length() - 3) { // when the word is almost solved
                        System.out.print(i+1 + "/" + location.length() + " of the job done! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". We're really close now!\n");
                        correct = true; // the math question was solved correctly
                     }
                     else { // when a letter is found, but word not almost solved
                        System.out.print(i+1 + "/" + location.length() + " parts done! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". Good work! On to the next one:\n");
                        correct = true; // the math question was solved correctly
                     }
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
         roundProgress *= 10; // next round uses 1 more digit with multiplication and division
         if (roundProgress > 1000) {
            roundProgress=1000;
         }
            
      }
      if (keepPlaying == false) { // messages displayed if the user quits after a round
         System.out.println("Thanks for your help. Please try and assist us again soon, as Syndrome is still on the loose.");
      }
      else if (roundNum == 4) { // on the fourth and final round
         String location = Location(roundNum); // String location is the retunred location from the method: Location 
         System.out.println("We are almost done agent! We just need to decode one more peice of information!");
         num1 = rand.nextInt(10 * roundProgress); //random 4 digit number
         num2 = rand.nextInt(1 * roundProgress); // random 3 digit number
         boolean correct = false; // counter for if the question was answered correctly
         while (correct==false) {
            System.out.print("can you solve the last question? " + num1 + " * " + num2 + " = ");
            int answer = kb.nextInt();
            if (answer == num1*num2) { // when answer is correct
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
    
    public static void fraction(String userName) {
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.println("\nDecode the secret message below!\n");
        boolean keepPlaying = true; // keeps track if the user still wants to play
        int roundNum = 1; //  counter for what round is the user on, also adjusts difficulty
        int num1, num2, num3, num4; //Four numbers that make up the fractions
        double num1D,num2D,num3D,num4D; //changes the four numbers to doubles so the program can compare the fractions
        while (keepPlaying==true && roundNum <= 3) { // within the three rounds, and when the user doesnt want to quit
            String location = Location(roundNum); // String location is the retunred location from the method: Location 
            for (int i=0; i<location.length(); i++){
                num1=0;
                num2=0;
                num3=0;
                num4=0;
                while (num2==0 || num4==0) { // ensuring that the numbers are greater than 0, also adjusts difficulty
                    num1 = rand.nextInt(10+5*(roundNum-1));
                    num2 = rand.nextInt(10+5*(roundNum-1));
                    num3 = rand.nextInt(10+5*(roundNum-1));
                    num4 = rand.nextInt(10+5*(roundNum-1));
                }
                boolean correct = false; // counter for if the question was answered correctly
                while (correct==false) {
                    num1D=num1;
                    num2D=num2;
                    num3D=num3;
                    num4D=num4;
                    System.out.print("Is "+num1 + "/" + num2+" greater than, less than, or equal to "+num3+"/"+num4+"? "); 
                    System.out.print("(Enter >, <, or =.): ");
                    String answer = kb.nextLine();
                    //if statements for when the first fraction is greater than the second fraction
                    if (answer.equals(">") && num1D/num2D > num3D/num4D && i == location.length() - 1) { // when the last letter is found
                    System.out.print(i+1 + "/" + location.length() + " of the message decoded! ");
                    System.out.print("You found the letter " + location.charAt(i));
                    System.out.println(". You found the last one!\n");
                    correct = true; // the math question was solved correctly
                    }
                    else if (answer.equals(">") && num1D/num2D>num3D/num4D && i >= location.length() - 3) { // when the word is almost solved
                        System.out.print(i+1 + "/" + location.length() + " of the job done! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". We're really close now!\n");
                        correct = true; // the math question was solved correctly
                    }
                    else if (answer.equals(">")&& num1D/num2D>num3D/num4D) { // when a letter is found, but word not almost solved
                        System.out.print(i+1 + "/" + location.length() + " parts done! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". Good work! On to the next one:\n");
                        correct = true; // the math question was solved correctly
                    }
                    //if statements for when the first fraction is less than the second
                    else if (answer.equals("<") && num1D/num2D < num3D/num4D && i == location.length() - 1) { // when the last letter is found
                        System.out.print(i+1 + "/" + location.length() + " of the message decoded! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". You found the last one!\n");
                        correct = true; // the math question was solved correctly
                    }
                    else if (answer.equals("<") && num1D/num2D<num3D/num4D && i >= location.length() - 3) { // when the word is almost solved
                        System.out.print(i+1 + "/" + location.length() + " of the job done! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". We're really close now!\n");
                        correct = true; // the math question was solved correctly
                    }
                    else if (answer.equals("<")&& num1D/num2D< num3D/num4D) { // when a letter is found, but word not almost solved
                        System.out.print(i+1 + "/" + location.length() + " parts done! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". Good work! On to the next one:\n");
                        correct = true; // the math question was solved correctly
                    }
                    //if statements when the fractions are equal               
                    else if (answer.equals("=") && num1D/num2D==num3D/num4D && i == location.length() - 1) { // when the last letter is found
                        System.out.print(i+1 + "/" + location.length() + " of the message decoded! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". You found the last one!\n");
                        correct = true; // the math question was solved correctly
                    }
                    else if (answer.equals("=") && num1D/num2D==num3D/num4D && i >= location.length() - 3) { // when the word is almost solved
                        System.out.print(i+1 + "/" + location.length() + " of the job done! ");
                        System.out.print("You found the letter " + location.charAt(i));
                        System.out.println(". We're really close now!\n");
                        correct = true; // the math question was solved correctly
                    }
                    else if (answer.equals("=")&& num1D/num2D==num3D/num4D) { // when a letter is found, but word not almost solved
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
        }
        if (keepPlaying == false) { // messages displayed if the user quits after a round
         System.out.println("Thanks for your help. Please try and assist us again soon, as Syndrome is still on the loose.");
        }
        else if (roundNum == 4) { // on the fourth and final round
            String location = Location(roundNum); // String location is the retunred location from the method: Location 
            num1=0;
            num2=0;
            num3=0;
            num4=0;
            System.out.println("We are almost done agent! We just need to decode one more peice of information!");
            while (num2==0 || num4==0) { // ensuring that the numbers are greater than 0, and adjusts difficulty
                num1 = rand.nextInt(10+5*(roundNum-1));
                num2 = rand.nextInt(10+5*(roundNum-1));
                num3 = rand.nextInt(10+5*(roundNum-1));
                num4 = rand.nextInt(10+5*(roundNum-1));
                boolean correct = false; // counter for if the question was answered correctly
                while (correct==false) {
                    num1D=num1;
                    num2D=num2;
                    num3D=num3;
                    num4D=num4;
                    System.out.print("can you solve the last question? " + num1 + " + " + num2 + " = ");
                    String answer = kb.nextLine();
                    if (answer.equals("greater than") && num1D/num2D > num3D/num4D) { 
                        System.out.println("You found the word " + location);
                        correct = true; // the question was answered correctly
                    }
                        else if (answer.equals("less than") && num1D/num2D < num3D/num4D) { 
                        System.out.println("You found the word " + location);
                        correct = true; // the question was answered correctly
                    }
                        else if (answer.equals("equal to") && num1D/num2D==num3D/num4D) { // when the last letter is found
                        System.out.println("You found the word " + location);
                        correct = true; // the question was answered correctly
                    }
                    else { // when answer was incorrect
                        System.out.println("Darn it, thats the wrong answer. Give it another try agent!");
                    }
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
            " we were able to figure out Syndrome's evil plans! \nThank you for your help agent, your" +
            " assistance was invaluable in saving the world!";
            JOptionPane.showMessageDialog(null,finalMsg);
            }
        }
        if (keepPlaying == false && roundNum == 4) { // messages displayed if the user quits after round 4
            System.out.println("Thanks for your help. Please try and assist us again soon. We were so close!");
        }
    }
}

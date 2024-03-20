package com.company;
import java.util.Random;
import java.util.Scanner;


    class Game{
        public int number;
        public int inputNumber;
        public int noOfGuesses = 0;

        public int getNoOfGuesses() {
            return noOfGuesses;
        }

        public void setNoOfGuesses(int noOfGuesses) {
            this.noOfGuesses = noOfGuesses;
        }

        Game(){
            // Generating random number
            Random rand = new Random();
            this.number = rand.nextInt(100);
        }
        void takeUserInput(){
            // Taking user input
            System.out.print("Guess the number :-");
            Scanner sc = new Scanner(System.in);
            inputNumber = sc.nextInt();
        }
        boolean isCorrectNumber(){
            noOfGuesses++;
            if (inputNumber==number){
                System.out.format("Yes you guessed it right, it was %d\nYou guessed it in %d attempts", number, noOfGuesses);
                return true;
            }
            else if(inputNumber<number){
                System.out.println("Your Guess is Too low...");
            }
            else if(inputNumber>number){
                System.out.println("Your Guess is Too high...");
            }
            return false;
        }

    }
    public class project1 {
        public static void main(String[] args) {

            Game g = new Game();
            boolean b= false;
            while(!b){
                g.takeUserInput();
                b = g.isCorrectNumber();
            }

        }
    }



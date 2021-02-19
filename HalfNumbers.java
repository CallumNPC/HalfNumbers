package NPC;

import java.util.Scanner;

public class HalfNumbers {

    public static void main(String[] args) {
            // main code. runs once and then asks if the user wants to repeat
        runHalfNumber();
        System.out.println("Would you like to try another number?");

        boolean loop = true;

        while (loop) {

            Scanner input = new Scanner(System.in);
            String runAgain = input.nextLine();

            if (runAgain.equalsIgnoreCase("YES") || runAgain.equalsIgnoreCase("Y")) {
                runHalfNumber();
                System.out.println("Would you like to try another number?");
            } else {
                System.out.println("You didn't answer YES");
                loop = false;
            }
        }
    }

    public static void runHalfNumber() {
        // First get input list and then applies maths until 1

        int usersNumber = getUserNumber();

        calculateToOne(usersNumber);

    }

    public static int getUserNumber() {
        // get an input of the user's number and make sure it's an int and >1

        int userNumberTest;
        System.out.print("Enter a number: ");
        Scanner input = new Scanner(System.in);

        if (input.hasNextInt()) {
            // if the input is an int, then set that as the user's number
            userNumberTest = input.nextInt();
        } else {
            // the user didn't enter a number so start again
            System.out.println("That is not a number");
            // if the number is longer than an int can handle it says it's not a number
            userNumberTest = getUserNumber();
        }

        if (userNumberTest <= 1) {
            System.out.println("The number needs to a positive number bigger than 1");
            userNumberTest = getUserNumber();
        }

        return userNumberTest;

    }

    public static void calculateToOne(int usersNumber) {
        // take number, check if odd or even, until it gets to 1
        int count = 0;

        while (usersNumber != 1) {
            int newNumber;
            if (isNumberEven(usersNumber)) {
                newNumber = usersNumber / 2;
                System.out.println(usersNumber + " is even so I take half: " + newNumber);

            } else {
                newNumber = 3 * usersNumber + 1;
                System.out.println(usersNumber + " is odd, so I make 3n + 1: "+ newNumber);
            }
            usersNumber = newNumber;
            count++;
        }
        System.out.println("The process took " + count + " to reach 1");

    }

    public static boolean isNumberEven(int checkNumber) {
        // take the int and check if it is even (or not)

        return checkNumber % 2 == 0;

    }

}

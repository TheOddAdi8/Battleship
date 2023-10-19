import java.util.Scanner;

public class Instructions { //provides instructions for user

    public static void wait(int ms) { //wait method again to pause for a certain period of time before moving on
        try {
        Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    Scanner enterBot = new Scanner(System.in);
    public Instructions() { //constructor to provide all the instructions to the user
        //Welcome
        System.out.println("\n\nWELCOME TO BATTLESHIP!!!\n"); wait(2000);
        System.out.println("Type \"rules\" to see the rules of this game. It provides valuable tips as well.");
        System.out.println("If not, just hit enter on your keyboard.");
        String enter = enterBot.nextLine();
        if (enter.equalsIgnoreCase("rules")) {
            rulesAndStuff();
        }
    }

    public void rulesAndStuff() {
        //Instructions
        System.out.println("\nRules:"); wait(100);
        System.out.println("You have two boards"); wait(100);
        System.out.println("One will be used for placing your ships (in normal mode)"); wait(100);
        System.out.println("And the other one will be for shooting enemy ships"); wait(100);
        System.out.println("The goal of this game is to try to guess where the enemy ships are"); wait(100);
        System.out.println("Next, the instructions will be listed");
        wait(2000);
        System.out.println("\nInstructions/tips:"); wait(100);
        System.out.println("1. You will see a 10 by 10 board on the screen"); wait(100);
        System.out.println("2. Row number refers to the row position from the top row"); wait(100);
        System.out.println("3. Column number refers to the column position from the leftmost column"); wait(100);
        System.out.println("4. If the direction of the ship is one direction, then the rest of the ship will generate in the opposite direction");
        System.out.println("     a. Example: If ship points up, the rest of the ship will generate below the head (bow) of the ship"); wait(100);
        System.out.println("5. Ships cannot be moved after placement"); wait(100);
        System.out.println("6. Ships must be placed on the board"); wait(100);
        System.out.println("7. Ships may not be placed diagonally"); wait(100);
        System.out.println("8. Ships cannot overlap"); wait(100);
        System.out.println("9. You will not be notified when a ship has sunk"); wait(100);
        System.out.println("10. 0 means empty slot"); wait(100);
        System.out.println("11. 1 means there is a ship"); wait(100);
        System.out.println("12. 2 means a ship has been hit"); wait(100);
        System.out.println("13. 3 means the user has missed"); wait(100);
        System.out.println("14. Have fun!"); wait(2000);
        System.out.println("(Press enter to continue)");
        String temp = enterBot.nextLine(); //temp is a useless variable
        System.out.println("");
    }

    public int normalFast() {
        System.out.println("Would you like to play normal mode or fast mode?"); wait(100);
        System.out.println("Normal is when someone places ships and the other person guesses the locations of the ships."); wait(100);
        System.out.println("Fast is when the computer places ships and you have to guess the locations of the ships."); wait(100);
        String normalFast = enterBot.nextLine();
        if (normalFast.equalsIgnoreCase("normal")) {
            return 1;
        }
        else if (normalFast.equalsIgnoreCase("fast")) {
            return 2;
        }
        else {
            return normalFast();
        }
    }
}

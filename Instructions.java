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
        //Instructions
        System.out.println("Instructions:"); wait(200);
        System.out.println("1. You will see a 10 by 10 board on the screen"); wait(200);
        System.out.println("2. Row number refers to the row position from the top row"); wait(200);
        System.out.println("3. Column number refers to the column position from the leftmost column"); wait(200);
        System.out.println("4. If the direction of the ship is one direction, then the rest of the ship will generate in the opposite direction");
        System.out.println("     a. Example: If ship points up, the rest of the ship will generate below the head (bow) of the ship"); wait(200);
        System.out.println("5. Ships cannot be moved after placement"); wait(200);
        System.out.println("6. Ships must be placed on the board"); wait(200);
        System.out.println("7. Ships may not be placed diagonally"); wait(200);
        System.out.println("8. Ships cannot overlap"); wait(200);
        System.out.println("9. You will not be notified when a ship has sunk"); wait(200);
        System.out.println("10. 0 means empty slot"); wait(200);
        System.out.println("11. 1 means there is a ship"); wait(200);
        System.out.println("12. 2 means a ship has been hit"); wait(200);
        System.out.println("13. 3 means the user has missed"); wait(200);
        System.out.println("14. Have fun!"); wait(1000);
        System.out.println("(Press enter to continue)");
        String temp = enterBot.nextLine(); //temp is a useless variable
        System.out.println("");
    }
}

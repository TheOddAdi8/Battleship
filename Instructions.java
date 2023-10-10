import java.util.Scanner;

public class Instructions {
    Scanner enterBot = new Scanner(System.in);
    public Instructions() { //constructor
        //Welcome
        System.out.println("\n\nWELCOME TO BATTLESHIP!!!\n");
        //Instructions
        System.out.println("Instructions:");
        System.out.println("1. You will see a 10 by 10 board on the screen");
        System.out.println("2. Row number refers to the row position from the top row");
        System.out.println("3. Column number refers to the column position from the leftmost column");
        System.out.println("4. If the direction of the ship is one direction, then the rest of the ship will generate in the opposite direction");
        System.out.println("     a. Example: If ship points up, the rest of the ship will generate below the head (bow) of the ship");
        System.out.println("5. Ships cannot be moved after placement");
        System.out.println("6. Ships must be placed on the board");
        System.out.println("7. Ships may not be placed diagonally");
        System.out.println("8. Ships cannot overlap");
        System.out.println("9. The game does not completely function");
        System.out.println("10. Have fun!");
        System.out.println("(Press enter to continue)");
        String temp = enterBot.nextLine();
        System.out.println("");
    }
}

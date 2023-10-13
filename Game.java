import java.util.Scanner;

public class Game {
    /* 0 = end game
     *  1 = user turn
     *  2 = bot turn
     */
    static Scanner scanBot = new Scanner(System.in);

    public static int shootRow = 0;
    public static int shootCol = 0;

    public static int rowGame() {
        while (shootRow < 1 || shootRow > 10) {
            System.out.println("\nWhat row would you like to shoot? ");
            shootRow = scanBot.nextInt();
        }
        return shootRow;
    }
    public static int colGame() {
        while (shootCol < 1 || shootCol > 10) {
            System.out.println("What column would you like to shoot? ");
            shootCol = scanBot.nextInt();
        }
        return shootCol;
    }

}

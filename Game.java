import java.util.Scanner;

public class Game {

    static Scanner scanBot = new Scanner(System.in);

    public static int shootRow = 0;
    public static int shootCol = 0;

    public int rowGame() {
        while (shootRow < 1 || shootRow > 10) {
            System.out.println("What row would you like to shoot? ");
            shootRow = scanBot.nextInt();
        }
        return (shootRow - 1);
    }
    public int colGame() {
        while (shootCol < 1 || shootCol > 10) {
            System.out.println("What column would you like to shoot? ");
            shootCol = scanBot.nextInt();
        }
        return (shootCol - 1);
    }
}

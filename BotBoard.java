import java.util.Random;

public class BotBoard {
    Random randomBot = new Random();

    final int numRowsCols = 10;

    int[][] botGame = new int[numRowsCols][numRowsCols];

    public int randomNumber() {
        int randomNum = randomBot.nextInt(numRowsCols);
        return randomNum;
    }
}

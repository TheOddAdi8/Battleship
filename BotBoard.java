/**
 * BotBoard.java
 * @author Adi Duggal
 * @since 10/19/2023
 * @version 1.0.0
 * 
 * This class generates a random position and direction for ships for the fast game mode. 
 */

 import java.util.Random;

public class BotBoard { //creates a board for the bot
    Random randomBot = new Random();

    final int numRowsCols = 10;
    final int numDirections = 4;

    final int destroyerLength = 2;
    final int cruiserLength = 3;
    final int submarineLength = 3;
    final int battleshipLength = 4;
    final int carrierLength = 5;

    boolean isShip = false;
    int botRow = 0;
    int botCol = 0;
    int direction = 0;
    int endPos = 0;

    int[][] botGame = new int[numRowsCols][numRowsCols];

    public int randomNumber(int max) { //picks random number and returns it
        int randomNum = randomBot.nextInt(max);
        return randomNum;
    }

    public void checkShipPlacement(int shipLength) { //checks if ship exists in that spot, if it does, it picks another random spot and direction
        botRow = randomNumber(numRowsCols);
        botCol = randomNumber(numRowsCols);
        direction = randomNumber(numDirections) + 1;

        if (botGame[botRow][botCol] == 0) {
            if (direction == 1) {
                endPos = botRow + shipLength;
                if (endPos > numRowsCols) {
                    checkShipPlacement(shipLength);
                }
                else {
                    for (int i = numRowsCols; i < endPos; i++) {
                        if (botGame[i][botCol] == 1) {
                            isShip = true;
                        }
                    }
                    if (isShip == false) {
                        for (int i = botRow; i < endPos; i++) {
                            botGame[i][botCol] = 1;
                        }
                    }
                    else {
                        checkShipPlacement(shipLength);
                    }
                }
            }
            else if (direction == 2) {
                endPos = botRow - shipLength;
                if (endPos < 0) {
                    checkShipPlacement(shipLength);
                }
                else {
                    for (int i = botCol; i > endPos; i--) {
                        if (botGame[i][botCol] == 1) {
                            isShip = true;
                        }
                    }
                    if (isShip == false) {
                        for (int i = botCol; i > endPos; i--) {
                            botGame[i][botCol] = 1;
                        }
                    }
                    else {
                        checkShipPlacement(shipLength);
                    }
                }
            }
            else if (direction == 3) {
                endPos = botCol + shipLength;
                if (endPos > numRowsCols) {
                    checkShipPlacement(shipLength);
                }
                else {
                    for (int i = botCol; i < endPos; i++) {
                        if (botGame[botRow][i] == 1) {
                            isShip = true;
                        }
                    }
                    if (isShip == false) {
                        for (int i = botCol; i < endPos; i++) {
                            botGame[botRow][i] = 1;
                        }
                    }
                    else {
                        checkShipPlacement(shipLength);
                    }
                }
            }
            else if (direction == 4) {
                endPos = botCol - shipLength;
                if (endPos < 0) {
                    checkShipPlacement(shipLength);
                }
                else {
                    for (int i = botRow; i > endPos; i--) {
                        if (botGame[botRow][i] == 1) {
                            isShip = true;
                        }
                    }
                    if (isShip == false) {
                        for (int i = botRow; i > endPos; i--) {
                            botGame[botRow][i] = 1;
                        }
                    }
                    else {
                        checkShipPlacement(shipLength);
                    }
                }
            }
        }
    }
}
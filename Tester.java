/**
 * Tester.java
 * @author Adi Duggal
 * @since 10/19/2023
 * @version 1.0.0
 * 
 * This class runs the whole program and creates instances of all the other programs.
 */

import java.util.Scanner;

public class Tester { //hub to run all the code

    //defining ship lengths
    final static int destroyerLength = 2;
    final static int cruiserLength = 3;
    final static int submarineLength = 3;
    final static int battleshipLength = 4;
    final static int carrierLength = 5;

    final static int numRowsCols = 10;

    static String strShootRow = "";
    static String strShootCol = "";
    static String strSpotVal = "";
    static int shootRow = 0;
    static int shootCol = 0;
    static int spotVal = 0;
    static int numMoves = 0;
    static int counter = 0;

    static boolean userWin = false;

    static int[][] shootBoard = new int[numRowsCols][numRowsCols];

    static UserBoard ub1 = new UserBoard(); //creates main board for user
    static BotBoard bb1 = new BotBoard();
    static Scanner scanBot = new Scanner(System.in);

    public static void printBoard() { //prints the shooting board with guiding numbers from 1-10
        System.out.println("    1 2 3 4 5 6 7 8 9 10\n");
        for (int r = 0; r < numRowsCols; r++) {
            if (r == 0) {
                System.out.print("1   ");
            }
            else if (r == 1) {
                System.out.print("2   ");
            }
            else if (r == 2) {
                System.out.print("3   ");
            }
            else if (r == 3) {
                System.out.print("4   ");
            }
            else if (r == 4) {
                System.out.print("5   ");
            }
            else if (r == 5) {
                System.out.print("6   ");
            }
            else if (r == 6) {
                System.out.print("7   ");
            }
            else if (r == 7) {
                System.out.print("8   ");
            }
            else if (r == 8) {
                System.out.print("9   ");
            }
            else if (r == 9) {
                System.out.print("10  ");
            }
            for (int c = 0; c < numRowsCols; c++) {
                System.out.print(shootBoard[r][c] + " ");
            }
            System.out.println("");
        }
    }

    //Source: https://www.geeksforgeeks.org/wait-method-in-java-with-examples/
    public static void wait(int ms) { //method to wait for a certain period of time before moving on
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clear() { //Source: Mr. Twyford and Geeks for Geeks
        System.out.print("\033[H\033[2J");
    }

    public static void main(String[] args) { //main method
        Instructions i1 = new Instructions(); //welcomes user and shows instructions
        clear();
        int normalFast = i1.normalFast();
        clear();

        if (normalFast == 1) {
            ub1.printBoard(); wait(500); //shows board

            //sets ship positions and directions    
            ub1.userSetShipPos("Destroyer", destroyerLength);
            clear();
            ub1.printBoard(); wait(500);
            ub1.userSetShipPos("Cruiser", cruiserLength);
            clear();
            ub1.printBoard(); wait(500);
            ub1.userSetShipPos("Submarine", submarineLength);
            clear();
            ub1.printBoard(); wait(500);
            ub1.userSetShipPos("Battleship", battleshipLength);
            clear();
            ub1.printBoard(); wait(500);
            ub1.userSetShipPos("Carrier", carrierLength);
            clear();
        }
        else if (normalFast == 2) {
            bb1.checkShipPlacement(2);
            bb1.checkShipPlacement(3);
            bb1.checkShipPlacement(3);
            bb1.checkShipPlacement(4);
            bb1.checkShipPlacement(5);
        }

        System.out.print("\nCreating board"); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);
        clear();
        System.out.print("\nCreating board"); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);

        System.out.print("\nComplete"); wait(1000);
        System.out.println("\nGame begins"); wait(1000);
        System.out.println("DON'T"); wait(500);
        System.out.println("ENTER"); wait(500);
        System.out.println("A"); wait(500);
        System.out.println("NUMBER"); wait(500);
        System.out.println("THAT"); wait(500);
        System.out.println("ISN'T"); wait(500);
        System.out.println("ON"); wait(500);
        System.out.println("THE"); wait(500);
        System.out.println("BOARD!"); wait(1000);
        clear();

        if (normalFast == 1) {
            do {
                ub1ShootStuff();
                clear();
            }
            while (userWin == false);
        }
        else if (normalFast == 2) {
            do {
                bb1ShootStuff();
                clear();
            }
            while (userWin == false);
        }

        clear(); //just to be sure :)
        System.out.println("Yay! you won in " + numMoves + " moves!");
        if (numMoves == 17) {
            System.out.println("You got the highest score possible!");
        }
        System.out.println("Restart the program to play again.\n");
    }
    public static void ub1ShootStuff() { // shooting in the normal game mode
        shootRow = 0;
        shootCol = 0;
        spotVal = -1;
        strShootRow = "";
        strShootCol = "";
        strSpotVal = "";
        numMoves++;
        printBoard();
        while (shootRow < 1 || shootRow > 10) {
            while (!strShootRow.matches("[0-9]+")) {
                System.out.println("What row would you like to shoot?");
                strShootRow = scanBot.nextLine();
            }
            shootRow = Integer.parseInt(strShootRow);
        }
        shootRow--;
        while (shootCol < 1 || shootCol > 10) {
            while (!strShootCol.matches("[0-9]+")) {
                System.out.println("What column would you like to shoot?");
                strShootCol = scanBot.nextLine();
            }
            shootCol = Integer.parseInt(strShootCol);
        }
        shootCol--;
        spotVal = ub1.game[shootRow][shootCol];
        clear();
        if (spotVal == 1) {
            shootBoard[shootRow][shootCol] = 2;
            ub1.game[shootRow][shootCol] = 2;
            System.out.println("You hit a ship!\n");
            spotVal = -1;
        }
        else if (spotVal == 0) {
            shootBoard[shootRow][shootCol] = 3;
            ub1.game[shootRow][shootCol] = 3;
            System.out.println("You missed!\n");
            spotVal = -1;
        }
        else if (spotVal == 2 || spotVal == 3) {
            System.out.println("You already shot there! Try looking at the board next time.\n");
            spotVal = -1;
        }
        wait(500);
        counter = 0;
        for (int r = 0; r < numRowsCols; r++) {
            for (int c = 0; c < numRowsCols; c++) {
                if (ub1.game[r][c] == 1) {
                    counter++;
                }
            }
        }
        if (counter == 0) {
            userWin = true;
        }
    }

    public static void bb1ShootStuff() { //shooting in the fast game mode
        shootRow = 0;
        shootCol = 0;
        spotVal = -1;
        strShootRow = "";
        strShootCol = "";
        strSpotVal = "";
        printBoard();
        numMoves++;
        while (shootRow < 1 || shootRow > 10) {
            while (!strShootRow.matches("[0-9]+")) {
                System.out.println("What row would you like to shoot?");
                strShootRow = scanBot.nextLine();
            }
            shootRow = Integer.parseInt(strShootRow);
        }
        shootRow--;
        while (shootCol < 1 || shootCol > 10) {
            while (!strShootCol.matches("[0-9]+")) {
                System.out.println("What column would you like to shoot?");
                strShootCol = scanBot.nextLine();
            }
            shootCol = Integer.parseInt(strShootCol);
        }
        shootCol--;
        spotVal = bb1.botGame[shootRow][shootCol];
        clear();

        if (spotVal == 1) {
            shootBoard[shootRow][shootCol] = 2;
            bb1.botGame[shootRow][shootCol] = 2;
            System.out.println("You hit a ship!\n");
            spotVal = -1;
        }
        else if (spotVal == 0) {
            shootBoard[shootRow][shootCol] = 3;
            bb1.botGame[shootRow][shootCol] = 3;
            System.out.println("You missed!\n");
            spotVal = -1;
        }
        else if (spotVal == 2 || spotVal == 3) {
            System.out.println("You already shot there! Try looking at the board next time.\n");
            spotVal = -1;
        }
        wait(500);
        counter = 0;
        for (int r = 0; r < numRowsCols; r++) {
            for (int c = 0; c < numRowsCols; c++) {
                if (bb1.botGame[r][c] == 1) {
                    counter++;
                }
            }
        }
        if (counter == 0) {
            userWin = true;
        }
    }
}

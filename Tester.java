/**
 * Tester.java
 * @author Adi Duggal
 * @since 10/18/2023
 * @version 1.0.0
 * 
 * This class runs the whole program and creates instances of all the other programs.
 */

public class Tester { //hub to run all the code

    //defining ship lengths
    final static int destroyerLength = 2;
    final static int cruiserLength = 3;
    final static int submarineLength = 3;
    final static int battleshipLength = 4;
    final static int carrierLength = 5;

    final static int numRowsCols = 10;

    static int shootRow = 0;
    static int shootCol = 0;

    static int[][] shootBoard = new int[numRowsCols][numRowsCols];

    //Source: https://www.geeksforgeeks.org/wait-method-in-java-with-examples/
    public static void wait(int ms) { //method to wait for a certain period of time before moving on
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
    }

    public void runGame() { //tries to get print 2 boards, main game board and shooting board
        
    }

    public static void main(String[] args) { //main method
        Instructions i1 = new Instructions(); //welcomes user and shows instructions
        clear();
        UserBoard ub1 = new UserBoard(); //creates main board for user
        Game g1 = new Game();

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

        ub1.printBoard(); //shows new board
        System.out.print("\nCreating enemy board"); wait(1000);
        System.out.print("."); wait(1000);
        System.out.print("."); wait(1000);
        System.out.print("."); wait(1000);
        System.out.print("\nComplete"); wait(2000);
        System.out.println("\nGame begins"); wait(2000);
        clear();

        BotBoard bb1 = new BotBoard(); wait(2000);
        clear();

        for (int r = 0; r < numRowsCols; r++) {
            for (int c = 0; c < numRowsCols; c++) {
                System.out.print(ub1.game[r][c] + " ");
            }
            System.out.print("          ");
            for (int c = 0; c < numRowsCols; c++) {
                System.out.print(shootBoard[r][c] + " ");
            }
            System.out.println("");
        }

        boolean endGame = false;

        while (endGame == false) {
            shootRow = g1.rowGame();
            shootCol = g1.colGame();

            if (bb1.botGame[shootRow][shootCol] == 1) {
                System.out.println("\n\n You hit a ship!");
                System.out.println(false);
            }
            //else if (bb1.bo)
        }

    }
}

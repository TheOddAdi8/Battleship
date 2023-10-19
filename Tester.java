/**
 * Tester.java
 * @author Adi Duggal
 * @since 10/19/2023
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
    static int spotVal = 0;
    static int numMoves = 0;
    static int counter = 0;

    static boolean userWin = false;

    static int[][] shootBoard = new int[numRowsCols][numRowsCols];

    static UserBoard ub1 = new UserBoard(); //creates main board for user
    static Game g1 = new Game();

    public static void printBoards() {
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
        i1.normalFast();

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
        System.out.print("\nCreating board"); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);
        clear();
        ub1.printBoard(); //shows new board
        System.out.print("\nCreating board"); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);
        System.out.print("."); wait(500);

        System.out.print("\nComplete"); wait(1000);
        System.out.println("\nGame begins"); wait(1000);
        clear();

        do {
            shootStuff();
        }
        while (userWin == false);
    }
    public static void shootStuff() {
        shootRow = 0;
        shootCol = 0;
        spotVal = -1;
        numMoves++;
        shootRow = g1.rowGame();
        shootCol = g1.colGame();
        spotVal = ub1.game[shootRow][shootCol];
        //clear();
        if (spotVal == 1) {
            shootBoard[shootRow][shootCol] = 2;
            System.out.println("You hit a ship!\n");
            spotVal = -1;
        }
        else if (spotVal == 0) {
            shootBoard[shootRow][shootCol] = 3;
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
}

import java.util.Scanner;

public class Board {
    Scanner shipBot = new Scanner(System.in);
    int numRows = 10;
    int numCols = 10;

    final int destroyerLength = 2;
    final int cruiserLength = 3;
    final int submarineLength = 3;
    final int battleshipLength = 4;
    final int carrierLength = 5;

    int[] ships = new int[5]; //{2, 3, 3, 4, 5};

    int[][] game = new int[numRows][numCols];

    public void printBoard() {

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {

                System.out.print(game[r][c] + " ");

            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    int rowPos = 0;
    int colPos = 0;
    int shipDir = 0;

    public void placeShip() {
        //Destroyer (2-units)
        do {
            System.out.print("Enter the row number (1-10) of the head of the Destroyer (2 units): ");
            rowPos = shipBot.nextInt();
        }
        while (rowPos < 1 || rowPos > 10);
        rowPos--;

        do {
            System.out.print("Enter the column number (1-10) of the head of the Destroyer (2 units): ");
            colPos = shipBot.nextInt();
        }
        while (colPos < 1 || colPos > 10);
        colPos--;

        setShipDir("Destroyer");
        
    }
    
    public void setShipDir(String shipName) {
        System.out.println("");
        do {
            System.out.println("What direction would you like the " + shipName + " to face?");
            System.out.print("1. Up \n2. Down \n3. Left \n4. Right \n");
            shipDir = shipBot.nextInt();
        }
        while (shipDir < 1 || shipDir > 4); 
        
        if (shipDir == 1) {
            if (rowPos + destroyerLength >= numRows) {
                System.out.println("\nSorry but you cannot place the ship there\n");
                setShipDir("Destroyer");
            }
        }
    }
}

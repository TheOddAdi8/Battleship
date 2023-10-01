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

    //**************
    //*  0 = empty *
    //*  1 = ship  *
    //*  2 = hit   *
    //*  3 = miss  *
    //**************

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

    public void setShipPos() {
        //Destroyer (2-units)
        do {
            System.out.print("Enter the row number (1-10) of the head of the Destroyer (2 units): ");
            rowPos = shipBot.nextInt();
        }
        while (rowPos < 1 || rowPos > 10);
        rowPos = rowPos - 1;

        do {
            System.out.print("Enter the column number (1-10) of the head of the Destroyer (2 units): ");
            colPos = shipBot.nextInt();
        }
        while (colPos < 1 || colPos > 10);
        colPos = colPos - 1;



        setShipDir("Destroyer", destroyerLength);
        
    }
    
    public void setShipDir(String shipName, int shipLength) {
        System.out.println("");
        do {
            System.out.println("What direction would you like the " + shipName + " to face?");
            System.out.print("1. Up \n2. Down \n3. Left \n4. Right \n\n");
            shipDir = shipBot.nextInt();
        }
        while (shipDir < 1 || shipDir > 4); 
        
        int endPos;

        if (shipDir == 1) {
            endPos = rowPos + shipLength;
            if (endPos > numRows) {
                errorMsg();
                setShipDir(shipName, shipLength);
            }
            else {
                for (int i = rowPos; i < endPos; i++) {
                    game[i][colPos] = 1;
                }
            }
        }
        else if (shipDir == 2) {
            endPos = rowPos - shipLength;
            if (endPos < 0) {
                errorMsg();
                setShipDir(shipName, shipLength);
            }
            else {
                for (int i = colPos; i > endPos; i--) {
                    game[i][colPos] = 1;
                }
            }
        }
        else if (shipDir == 3) {
            endPos = colPos + shipLength;
            if (endPos > numCols) {
                errorMsg();
                setShipDir(shipName, shipLength);
            }
            else {
                for (int i = colPos; i < endPos; i++) {
                    game[rowPos][i] = 1;
                }
            }
        }
        else if (shipDir == 4) {
            endPos = colPos - shipLength;
            if (endPos < 0) {
                errorMsg();
                setShipDir(shipName, shipLength);
            }
            else {
                for (int i = rowPos; i > endPos; i--) {
                    game[rowPos][i] = 1;
                }
            }
        }
        System.out.println("");
    }

    public void errorMsg() {
        System.out.println("\nSorry but you cannot place the ship there\n");
    }
}

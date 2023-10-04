import java.util.Scanner;

public class UserBoard {
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

    public void userSetShipPos(String shipName, int shipLength) {
        //Destroyer (2-units)
        do {
            System.out.println("");
            System.out.print("Enter the row number (1-10) of the head of the " + shipName + " (" + shipLength + " units): ");
            rowPos = shipBot.nextInt();
        }
        while (rowPos < 1 || rowPos > 10);
        rowPos = rowPos - 1;

        do {
            System.out.print("Enter the column number (1-10) of the head of the " + shipName + " (" + shipLength + " units): ");
            colPos = shipBot.nextInt();
        }
        while (colPos < 1 || colPos > 10);
        colPos = colPos - 1;

        System.out.println("");
        userSetShipDir(shipName, shipLength);
        
    }
    
    public void userSetShipDir(String shipName, int shipLength) {
        do {
            System.out.println("What direction would you like the " + shipName + " to face?");
            System.out.print("1. Up \n2. Down \n3. Left \n4. Right \n5. Go back to setting the ship position\n\n");
            shipDir = shipBot.nextInt();
        }
        while (shipDir < 1 || shipDir > 4); 
        
        int endPos;
        boolean isShip = false;

        if (shipDir == 1) {
            endPos = rowPos + shipLength;
            if (endPos > numRows) {
                errorMsg();
                userSetShipDir(shipName, shipLength);
            }
            else {
                for (int i = rowPos; i < endPos; i++) {
                    if (game[1][colPos] == 1) {
                        isShip = true;
                    }
                }
                if (isShip == false) {
                    for (int i = rowPos; i < endPos; i++) {
                        game[i][colPos] = 1;
                    }
                }
                else {
                    errorMsg();
                    userSetShipDir(shipName, shipLength);
                }
            }
        }
        else if (shipDir == 2) {
            endPos = rowPos - shipLength;
            if (endPos < 0) {
                errorMsg();
                userSetShipDir(shipName, shipLength);
            }
            else {
                for (int i = colPos; i > endPos; i--) {
                    if (game[i][colPos] == 1) {
                        isShip = true;
                    }
                }
                if (isShip == false) {
                    for (int i = colPos; i > endPos; i--) {
                        game[i][colPos] = 1;
                    }
                }
                else {
                    errorMsg();
                    userSetShipDir(shipName, shipLength);
                }
            }
        }
        else if (shipDir == 3) {
            endPos = colPos + shipLength;
            if (endPos > numCols) {
                errorMsg();
                userSetShipDir(shipName, shipLength);
            }
            else {
                for (int i = colPos; i < endPos; i++) {
                    if (game[rowPos][i] == 1) {
                        isShip = true;
                    }
                }
                if (isShip == false) {
                    for (int i = colPos; i < endPos; i++) {
                        game[rowPos][i] = 1;
                    }
                }
                else {
                    errorMsg();
                    userSetShipDir(shipName, shipLength);
                }
            }
        }
        else if (shipDir == 4) {
            endPos = colPos - shipLength;
            if (endPos < 0) {
                errorMsg();
                userSetShipDir(shipName, shipLength);
            }
            else {
                for (int i = rowPos; i > endPos; i--) {
                    if (game[rowPos][i] == 1) {
                        isShip = true;
                    }
                }
                if (isShip == false) {
                    for (int i = rowPos; i > endPos; i--) {
                        game[rowPos][i] = 1;
                    }
                }
                else {
                    errorMsg();
                    userSetShipDir(shipName, shipLength);
                }
            }
        }
        else if (shipDir == 5) {
            userSetShipPos(shipName, shipLength);
        }
    }

    public void errorMsg() {
        System.out.println("\nSorry but you cannot place the ship there\n");
    }
}

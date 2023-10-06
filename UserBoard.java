import java.util.Scanner;

public class UserBoard {
    Scanner shipBot = new Scanner(System.in); //Scanner class

    //defining number of rows and columns
    final int numRows = 10;
    final int numCols = 10;

    //defining ship lengths
    final int destroyerLength = 2;
    final int cruiserLength = 3;
    final int submarineLength = 3;
    final int battleshipLength = 4;
    final int carrierLength = 5;

    //tried to begin making an array for the start and end positions of each ship to determine whether a ship has been suk
    int[] destroyerStartEnd = new int[4];
    int[] cruiserStartEnd = new int[4];
    int[] submarineStartEnd = new int[4];
    int[] battleshipStartEnd = new int[4];
    int[] carrierStartEnd = new int[4];

    int[][] game = new int[numRows][numCols]; //Game board

    //Game board cheat sheet

    /***************
     *  0 = empty *
     *  1 = ship  *
     *  2 = hit   *
     *  3 = miss  *
     *  4 = sink? *
     **************/

    public void printBoard() { //prints out board in 10x10 shape

        for (int r = 0; r < numRows; r++) { //rows
            for (int c = 0; c < numCols; c++) { //columns

                System.out.print(game[r][c] + " "); //space for separate numbers

            }
            System.out.print("\n"); //enter to go to next row
        }
        System.out.println("");
    }

    //defining positions and direction, will later be assigned to a value
    int rowPos = 0;
    int colPos = 0;
    int shipDir = 0;

    public void userSetShipPos(String shipName, int shipLength) { //assigns a spot to the head of the ship
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
    
    public void userSetShipDir(String shipName, int shipLength) {//ask user what direction should the ship face
        do {
            System.out.println("What direction would you like the " + shipName + " to face?");
            System.out.print("1. Up \n2. Down \n3. Left \n4. Right \n5. Go back to setting the ship position\n\n");
            shipDir = shipBot.nextInt();
        }
        while (shipDir < 1 || shipDir > 4); 
        
        int endPos; //end position of the ship (rear end of ship)
        boolean isShip = false; //is there a ship already in that location

        if (shipDir == 1) { //checks if ship will be out of bounds
            endPos = rowPos + shipLength;
            if (endPos > numRows) {
                errorMsg();
                userSetShipDir(shipName, shipLength);
            }
            else { //checks if ship exists in that spot
                for (int i = rowPos; i < endPos; i++) {
                    if (game[1][colPos] == 1) {
                        isShip = true;
                    }
                }
                if (isShip == false) { //if ship doesn't exist
                    for (int i = rowPos; i < endPos; i++) {
                        game[i][colPos] = 1;
                    }
                }
                else { //if ship exists
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

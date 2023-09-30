import java.util.Scanner;

public class Board {
    Scanner shipBot = new Scanner(System.in);
    int numRows = 10;
    int numCols = 10;
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

    public void setPiece() {
        do {
            System.out.print("Enter the row number of the head of the 2-unit ship (1-10): ");
            rowPos = shipBot.nextInt();
        }
        while (rowPos < 1 || rowPos > 10);
        rowPos--;

        do {
            System.out.print("Enter the column number of the head of the 2-unit ship: ");
            colPos = shipBot.nextInt();
        }
        while (colPos < 1 || colPos > 10);
        colPos--;
        
    }
}

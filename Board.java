public class Board {
    
    int numRows = 10;
    int numCols = 10;
    int[] ships = new int[5]; //{2, 3, 3, 4, 5};

    int[][] game = new int[numRows][numCols];
    

    public void printBoard() {

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {

                System.out.print(game[r][c] + " ");

            }
            System.out.println("");
        }
    }
}

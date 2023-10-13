public class Tester {

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

    public static void wait(int ms) {
        try {
        Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void runGame() {
        for (int r = 0; r < numRowsCols; r++) {
            for (int c = 0; c < numRowsCols; c++) {
                System.out.print(ub1.game[r][c] + " ");
            }
            System.out.print("          ");
            for (int c = 0; c < numRowsCols; c++) {
                System.out.print(shootBoard[r][c] + " ");
            }
            System.out.println("");
            shootRow = g1.rowGame();
            shootCol = g1.colGame();
            
        }
    }

    public static void main(String[] args) { //main method
        Instructions i1 = new Instructions(); //welcomes user and shows instructions
        UserBoard ub1 = new UserBoard(); //creates main board for user
        Game g1 = new Game();

        ub1.printBoard(); wait(1000); //shows board
        //sets ship positions and directions    
        ub1.userSetShipPos("Destroyer", destroyerLength);
        ub1.userSetShipPos("Cruiser", cruiserLength);
        ub1.userSetShipPos("Submarine", submarineLength);
        ub1.userSetShipPos("Battleship", battleshipLength);
        ub1.userSetShipPos("Carrier", carrierLength);
        System.out.println("");
        ub1.printBoard(); //shows new board
        System.out.print("\nCreating enemy board"); wait(1000);
        System.out.print("."); wait(1000);
        System.out.print("."); wait(1000);
        System.out.println("."); wait(1000);
        System.out.println("Complete"); wait(2000);
        System.out.println("Game begins"); wait(2000);

        BotBoard bb1 = new BotBoard();

        runGame();

    }
}

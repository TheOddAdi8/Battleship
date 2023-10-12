public class Tester {

    //defining ship lengths
    final static int destroyerLength = 2;
    final static int cruiserLength = 3;
    final static int submarineLength = 3;
    final static int battleshipLength = 4;
    final static int carrierLength = 5;

    public static void wait(int ms) {
        try {
        Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) { //main method
        Instructions i1 = new Instructions(); //welcomes user and shows instructions
        UserBoard ub1 = new UserBoard(); //creates main board for user

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
        System.out.print("."); wait(1000);

        BotBoard bb1 = new BotBoard();

    }
}

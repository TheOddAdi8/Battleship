public class Tester {

    //defining ship lengths
    final static int destroyerLength = 2;
    final static int cruiserLength = 3;
    final static int submarineLength = 3;
    final static int battleshipLength = 4;
    final static int carrierLength = 5;

    public static void main(String[] args) { //main method
        Instructions i1 = new Instructions(); //welcomes user and shows instructions
        UserBoard b1 = new UserBoard(); //creates main board for user
        BotBoard 
        b1.printBoard(); //shows board
        //sets ship positions and directions
        b1.userSetShipPos("Destroyer", destroyerLength);
        b1.userSetShipPos("Cruiser", cruiserLength);
        b1.userSetShipPos("Submarine", submarineLength);
        b1.userSetShipPos("Battleship", battleshipLength);
        b1.userSetShipPos("Carrier", carrierLength);
        System.out.println("");
        b1.printBoard(); //shows new board
        System.out.println("\nCreating enemy board...\n");

    }
}

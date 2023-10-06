public class Tester {

    //defining ship lengths
    final static int destroyerLength = 2;
    final static int cruiserLength = 3;
    final static int submarineLength = 3;
    final static int battleshipLength = 4;
    final static int carrierLength = 5;

    //every method should have a comment

    public static void main(String[] args) {
        UserBoard b1 = new UserBoard();
        b1.printBoard();
        b1.userSetShipPos("Destroyer", destroyerLength);
        b1.userSetShipPos("Cruiser", cruiserLength);
        b1.userSetShipPos("Submarine", submarineLength);
        b1.userSetShipPos("Battleship", battleshipLength);
        b1.userSetShipPos("Carrier", carrierLength);
        System.out.println("");
        b1.printBoard();
    }
}

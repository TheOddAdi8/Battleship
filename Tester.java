public class Tester {

    final static int destroyerLength = 2;
    final static int cruiserLength = 3;
    final static int submarineLength = 3;
    final static int battleshipLength = 4;
    final static int carrierLength = 5;
    

    public static void main(String[] args) {
        Board b1 = new Board();
        b1.printBoard();
        b1.setShipPos("Destroyer", destroyerLength);
        b1.setShipPos("Cruiser", cruiserLength);
        b1.setShipPos("Submarine", submarineLength);
        b1.setShipPos("Battleship", battleshipLength);
        b1.setShipPos("Carrier", carrierLength);
        b1.printBoard();
    }
}
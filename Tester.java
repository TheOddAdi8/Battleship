public class Tester {
    public static void print(String output) {
        System.out.print(output);
    }
    public static void main(String[] args) {
        Board b1 = new Board();
        b1.printBoard();
        b1.setPiece();
    }
}
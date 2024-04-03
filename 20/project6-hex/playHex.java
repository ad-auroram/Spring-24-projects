public class playHex {


    public static void main( String [ ] args ) {
        Board game = new Board();
        Tile[][] board = game.makeBoard();
        game.printBoard(board);
    }
}

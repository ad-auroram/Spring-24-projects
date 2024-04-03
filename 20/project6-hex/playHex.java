public class playHex {
    public static void main( String [ ] args ) {
        Game game = new Game();
        Tile[][] board = game.makeBoard();
        System.out.println("Let's play Hex!\n");
        game.printBoard(board);
        System.out.println();
        Tile tile = board[3][6];
        tile.updateColor("red");
        game.printBoard(board);
    }
}

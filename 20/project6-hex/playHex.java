public class playHex {
    public static void main( String [ ] args ) {
        System.out.println("Let's play Hex!\n");
        Game game1 = new Game();
        game1.playGame("moves.txt");
        System.out.println();
        Game game2= new Game();
        game2.playGame("moves2.txt");

    }
}

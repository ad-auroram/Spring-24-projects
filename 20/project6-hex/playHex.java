public class playHex {
    public static void main( String [ ] args ) {
        System.out.println("Let's play Hex!\n");
        Game game1 = new Game();
        System.out.println("Game 1:");
        game1.playGame("moves.txt");
        System.out.println();
        System.out.println("Game 2:");
        Game game2= new Game();
        game2.playGame("moves2.txt");
        System.out.println("\n Thanks for playing!");


    }
}

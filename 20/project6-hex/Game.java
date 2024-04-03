import java.io.File;
import java.util.Scanner;

public class Game {
    int top;
    int right;
    int bottom;
    int left;

    public Game(){
        int right = 122;
        int left=123;
        int top=124;
        int bottom=125;
    }

    public Tile[][] makeBoard(){
        Tile[][] board = new Tile[11][11];
        for (int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                Tile space=new Tile((i*11)+j, null);
                board[i][j]=space;
            }
        }
        return board;
    }

    public void printBoard(Tile[][] board){
        String offset="";
        for (int i=0; i<11; i++) {
            System.out.print(offset);
            for (int j = 0; j < 11; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            offset+=" ";
        }
    }

    public void playGame(String input){
        int moves=0;
        String color= null;
        Tile[][] board = makeBoard();
        try {File file = new File(input);
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                moves+=1;
                int move= Integer.parseInt(reader.next());
                if (moves%2==0) color="red";
                else color="blue";
                int j = (move%11);
                if (j<0){
                    j=0;
                }
                int i = (move/11);
                Tile currTile = board[i][j];
                currTile.updateColor(color);
                printBoard(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(moves);
    }

    public static void main( String [ ] args ) {
        /* Testing
        Game game = new Game();
        Tile[][] board = game.makeBoard();
        System.out.println("Let's play Hex!\n");
        game.printBoard(board);
        System.out.println();
        Tile tile = board[3][6];
        tile.updateColor("red");
        Tile tile2 = board[9][2];
        tile2.updateColor("blue");
        game.printBoard(board);
        */
    }
}

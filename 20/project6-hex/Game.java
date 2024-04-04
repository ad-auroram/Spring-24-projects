import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int top=122;
    int right=123;
    int bottom=124;
    int left=125;

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

    public void findNeighbors(Tile tile, int move, UnionFind union, Tile[][] board){
        boolean edgeTop=false;
        boolean edgeBottom=false;
        boolean edgeRight=false;
        boolean edgeLeft=false;

        if (move%11==1){
            edgeLeft=true;
            if (tile.color=="blue"){
                union.union(move, left);
            }
        }
        if (move%11==0){
            edgeRight=true;
            if (tile.color=="blue"){
                union.union(move, right);
            }
        }
        if(move<=11){
            edgeTop=true;
            if (tile.color=="red"){
                union.union(move, top);
            }
        }
        if(move<=121&&move>=110){
            edgeBottom=true;
            if (tile.color=="red"){
                union.union(move, bottom);
            }
        }

        ArrayList<Integer> neighbors = new ArrayList<>();
        int[] offset= {-11,-10,-1,1,10,11};
        for (int i=0; i<6;i++){
            if((i==0 || i==1) &&edgeTop) continue;
            if((i==2 || i==4) &&edgeLeft) continue;
            if((i==1 || i==3) &&edgeRight) continue;
            if((i==4 || i==5) &&edgeBottom) continue;
            neighbors.add(move+ offset[i]);
        }

        for (int neighbor:neighbors){
            int[] coords = convertPlace(neighbor);
            Tile nextTo= board[coords[0]][coords[1]];
            if (nextTo.color==tile.color){
                union.union(move,neighbor);
            }
        }
    }

    public int[] convertPlace(int move){
        int i = (move/11);
        int j = (move%11-1);
        if (j<0){
            j=10;
            i--;
        }
        if(i>10){
            i=10;
        }
        return new int[]{i, j};
    }

    public boolean winner(UnionFind union){
        if (union.find(right)==union.find(left)){
            System.out.print("-------> Blue");
            return true;
        }
        if(union.find(top)==union.find(bottom)){
            System.out.print("-------> Red");
            return true;
        }
        return false;
    }
    public void playGame(String input){
        int moves=0;
        String color;
        Tile[][] board = makeBoard();
        UnionFind union = new UnionFind(125);
        try {File file = new File(input);
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                moves+=1;
                int move= Integer.parseInt(reader.next());
                if (moves%2==0) color="red";
                else color="blue";
                int[] places = convertPlace(move);
                Tile currTile = board[places[0]][places[1]];
                currTile.updateColor(color);
                findNeighbors(currTile, move, union, board);
                if (winner(union)) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" has won after "+moves+" moves! Here's the final board:");
        printBoard(board);

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

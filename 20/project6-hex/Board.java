public class Board {

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
}

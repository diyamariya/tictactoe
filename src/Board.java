
public class Board {

    private final char [][] board;
    private final int size;

    public Board(int size){
        this.size = size;
        board = new char [size] [size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board [i][j] = '_';
            }
        }
    }

    public int getSize(){
        return size;
    }

    void makeMove(int row, int col, char symbol){
        board[row][col] = symbol;
    }

    char[][] getBoard(){
        return board; // better to make deep copy for safety and encapsulation
    }


    public char getSquare(int row, int col){
        return board[row][col];
    }



    public boolean isFull(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == '_') return false;
            }
        }
        return true;
    }


    void displayBoard(){
        for( int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

}

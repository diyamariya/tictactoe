public class ProxyMove {
    private final Board board;

    public ProxyMove(Board board){
        this.board = board;
    }

    public boolean isSquareEmpty(int row, int col){
        return board.getSquare(row,col) == '_';
    }

    public boolean validate(int row, int col, char symbol){

        if(row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize())
        {
            System.out.println("OUT OF BOUNDS");
            return false;
        }

        if(!isSquareEmpty(row,col)){
            System.out.println("THAT SQUARE IS OCCUPIED");
            return false;
        }

        board.makeMove(row, col, symbol);
        return true;
    }
}

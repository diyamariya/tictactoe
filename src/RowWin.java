public class RowWin implements WinningStrategy{

    @Override
    public boolean checkWin(int row, int col, char symbol, Board board){

        for(int i = 0; i < board.getSize(); i++){
            if(board.getSquare(row,i) != symbol) return false;
        }
        return true;
    }
}

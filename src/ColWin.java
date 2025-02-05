public class ColWin implements WinningStrategy{

    @Override
    public boolean checkWin(int row, int col, char symbol, Board board){

        for(int i = 0; i < board.getSize(); i++){
            if(board.getSquare(i,col) != symbol) return false;
        }
        return true;
    }
}

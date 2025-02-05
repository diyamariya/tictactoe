public class DiagWin implements WinningStrategy{

    @Override
    public boolean checkWin(int row, int col, char symbol, Board board){

        int size = board.getSize();
        boolean diagwin1 = true;
        boolean diagwin2 = true;

        // Check primary diagonal
        if (row == col) {
            for (int i = 0; i < size; i++) {
                if (board.getSquare(i, i) != symbol) {
                    diagwin1 = false;
                    break;
                }
            }
        } else {
            diagwin1 = false; // Not on primary diagonal
        }

        // Check secondary diagonal
        if (row + col == size - 1) {
            for (int i = 0; i < size; i++) {
                if (board.getSquare(i, size - 1 - i) != symbol) {
                    diagwin2 = false;
                    break;
                }
            }
        } else {
            diagwin2 = false; // Not on secondary diagonal
        }

        // Return true if either diagonal is a win
        return diagwin1 || diagwin2;


    }
}

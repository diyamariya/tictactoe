public interface WinningStrategy {
    boolean checkWin(int row, int col, char symbol, Board board);
}

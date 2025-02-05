import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players;
    private final Board board;
    private final List<WinningStrategy> winningStrategies = new ArrayList<>();
    private Player currentplayer;

    public Game(List<Player>players, Board board){
        this.players = players;
        this.board = board;
        this.currentplayer = players.get(0); //START FROM FIRST PLAYER IN THE LIST
    }
    public void addWinningStrategy(WinningStrategy strategy){
        winningStrategies.add(strategy);
    }



    public void play(){
        while (!board.isFull()) {
            board.displayBoard();
            System.out.println("CURRENT PLAYER: " + currentplayer.getSymbol());


            currentplayer.wantsToMove();

            // Check if the current move caused a win
            if (checkWinner()) {
                board.displayBoard();
                System.out.println("PLAYER " + currentplayer.getSymbol() + " WON");
                return; // End the game
            }

            // Switch to the next player
            currentplayer = switchPlayer(currentplayer);
        }

        // draw
        board.displayBoard();
        System.out.println("DRAW!");
    }


    private boolean checkWinner(){

        for (WinningStrategy strategy : winningStrategies) {

            for (int row = 0; row < board.getSize(); row++) {

                for (int col = 0; col < board.getSize(); col++) {
                    if (strategy.checkWin(row, col, currentplayer.getSymbol(), board)) {
                        return true; // A win is detected
                    }
                }
            }
        }
        return false;
    }


    private Player switchPlayer(Player currentplayer){

        int index = players.indexOf(currentplayer);
        return players.get((index+1) %players.size()); //ROUND ROBIN THROUGH THE LIST
    }
}

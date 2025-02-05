import java.util.Random;

public class BotPlayer implements Player{

    private final char symbol;
    private final ProxyMove proxyMove;
    private final Board board;

    public BotPlayer(char symbol, ProxyMove proxyMove, Board board){

        this.symbol = symbol;
        this.proxyMove = proxyMove;
        this.board = board;
    }

    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public void wantsToMove(){

        boolean validMove = false;
        //System.out.println("BOT PLAYER " + symbol + " IS MAKING THEIR MOVE...");

        while(!validMove) {
            System.out.println("BOT PLAYER " + symbol + " IS MAKING THEIR MOVE...");
            Random r = new Random();
            int rowGuess = r.ints(1, 0, board.getSize()).findFirst().getAsInt();
            int colGuess = r.ints(1, 0, board.getSize()).findFirst().getAsInt();

            validMove = proxyMove.validate(rowGuess,colGuess,symbol);

        }

    }
}

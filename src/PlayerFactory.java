public class PlayerFactory {

    static Player createPlayer(String type, char symbol, Board board){

        ProxyMove proxyMove = new ProxyMove(board);

        if (type.equals("human")){
            return new HumanPlayer(symbol, proxyMove);
        }
        else if (type.equals("bot")){
            return new BotPlayer(symbol, proxyMove, board);
        }

        return null;
    }
}

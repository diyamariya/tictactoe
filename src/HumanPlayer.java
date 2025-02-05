import java.util.Scanner;

public class HumanPlayer implements Player {

    private final char symbol;
    private final ProxyMove proxyMove;

    public HumanPlayer(char symbol, ProxyMove proxyMove){
        this.symbol = symbol;
        this.proxyMove = proxyMove;
    }


    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public void wantsToMove(){

        Scanner sc = new Scanner (System.in);
        boolean validMove = false;

        while(!validMove) {
            System.out.print("WHERE DO YOU WANT TO MOVE, PLAYER " + symbol + " ?");
            int i = sc.nextInt();
            int j = sc.nextInt();

            validMove = proxyMove.validate(i,j,symbol);
            if(!validMove){
                System.out.println("TRY AGAIN");
            }

        }

    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter grid size n");
        int n = sc.nextInt();

        Board board = new Board(n);

        System.out.println("Enter number of players");
        System.out.println("Maximum number of players allowed is "+ (n-1));
        int p = sc.nextInt();

        System.out.println("Enter number of bot players");
        System.out.println("Maximum number of bot players is " + p);
        int botCount = sc.nextInt();
        int humanCount = p - botCount;

        List<Player> players = new ArrayList<>();
        char symbol = 'A';

        for(int i=0 ; i < humanCount; i++){
            players.add(PlayerFactory.createPlayer("human", symbol++, board));
        }

        for(int j = 0; j < botCount; j++){
            players.add(PlayerFactory.createPlayer("bot", symbol++, board));
        }

        System.out.println("Players created: ");
        for (Player player : players) {
            System.out.println("Player with symbol: " + player.getSymbol());
        }

        Game game = new Game(players, board);


        game.addWinningStrategy(new RowWin());
        game.addWinningStrategy(new ColWin());
        game.addWinningStrategy(new DiagWin());

        game.play();


        sc.close();

    }
}

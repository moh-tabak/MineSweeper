import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playAgain = null;
        do {
            Game.gamePlay();
            System.out.println("Do you like to play again? yes/no");
            playAgain = scan.next();
        } while(playAgain.equals("yes"));

    }
}
import java.util.*;  // util wildcard (random)

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        GameBord g1 = new GameBord();

       g1.print();

        System.out.println("PlayerX");
        String player = scan.nextLine();

        g1.playerSymbol( "1", "PlayerX");
    }
}
import java.util.*;  // util wildcard (random)

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        GameBord g1 = new GameBord();

       g1.print();

       while(true) {

           System.out.println("PlayerX pick a square!");
           String player = scan.nextLine();

           g1.playerSymbol(g1.GameTable, player, "PlayerX");

           g1.print();

       }


    }
}
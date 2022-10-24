import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    static Player player = new Player();


    public static void startText() {
        System.out.println("Welcome to MineSweeper!");
        System.out.println("What is your name?");
        player.setName(scan.nextLine());
        System.out.println("Welcome " + player.getName() + ", type your first move, row and column:");

    }

    public static void playerMove(){
        Scanner scan= new Scanner(System.in);
        GameBord gameBord= new GameBord();
        gameBord.fillWithMines();
        gameBord.print();
        int i=1;

        do{
            System.out.println("row: ");
            String row= scan.next();
            System.out.println("column: ");
            String column = scan.next();
            Square square = gameBord.move(row,column);
            gameBord.print();
            if (square.isMineHere==true) {
                System.out.println("Boom!! there is a bomb");
                i=0;
            }
            int d=0;
            if (d==14){// I have written 14 because there is 7 mines. if changed to how many mines the user wants it should be changed to (20 - user input)
                System.out.println("You won");
                i=0;
            }

        }while(i==1);

    }

}

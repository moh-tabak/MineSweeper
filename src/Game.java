import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    static Player player = new Player();
    static GameBord gamebord = new GameBord();

    static int mineCount;
    static int round = 0;


    public static void startText() {
        System.out.println("Welcome to MineSweeper!");
        System.out.println("What is your name?");
        player.setName(scan.nextLine());
        System.out.println("How many mines do you want? 1-19");
        mineCount = scan.nextInt();  // Ask player how many mines and set it in fillWithMines()
        System.out.println("Welcome " + player.getName() + ". You are playing with " + mineCount + " mines, type your first move, row and column:");
    }

    public static void gamePlay(){
        Scanner scan= new Scanner(System.in);
        GameBord table= new GameBord();
        table.fillWithMines();
        table.print();
        boolean gameEnded = false;
        int questionmarksRemaining = 20;
        round++;


        do{
            System.out.println("row: ");
            String row= scan.next();
            System.out.println("column: ");
            String column = scan.next();
            Square square = table.move(row,column);
            //countUncovered++;//count for how many tiles are uncovered, for winning argument below
            //System.out.println(" ? uncovered: " + countUncovered);//for developing purposes, comment out if game finished
            table.print();
            if (square.isMineHere==true) {
                System.out.println("Boom!! there is a bomb");
                gameEnded = playAgain(scan, gameEnded);
            }
            if(square.isUncovered==true){//it's not watertight. If you make a invalid move it still counts instead of ignores the already opened field.
                questionmarksRemaining--;
                System.out.println("Questionmarks remaining: " +questionmarksRemaining);
            }
            if (questionmarksRemaining == mineCount){//
                System.out.println("Yeah, you won!! You found all the mines");
                gameEnded = playAgain(scan, gameEnded);
            }

        }while(!gameEnded);
    }

    private static boolean playAgain(Scanner scan, boolean gameEnded) {
        boolean respons = true;
        do {// loop to initiate play again
            System.out.println("1. Entering while loop ");
            System.out.println("2. Would you like to play again? yes/no ");
            String play = scan.next();
            if (play.equals("yes")){
                System.out.println("1. Scanner input was yes");
                System.out.println("2. Let's play again");
                System.out.println("3. Get ready for round number " + round + " !|");
                respons = false;
            }else if (play.equals("no")) {
                System.out.println("1. Scanner input was no");
                System.out.println("2. Ok, thanks and have a wonderfull day.");
                gameEnded =true;
            }
        } while (respons);
        System.out.println("Round number: " + round);
        return gameEnded;
    }

}

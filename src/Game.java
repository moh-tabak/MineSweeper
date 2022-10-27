import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    static Player player = new Player();
    static GameBord table;
    static int mineCount;
    static InputOutputHelper ioh = new InputOutputHelper();


    public static void startText() {
        int limit;

        ioh.clearScreen();
        System.out.println("Welcome to MineSweeper!");
        System.out.println("What is your name?");
        player.setName(scan.nextLine());
        //TODO: Add error checking
        System.out.println("How big should the game board be?");
        table = new GameBord(ioh.getValidInt("Rows: "), ioh.getValidInt("Columns: "));

        limit = table.getGameTable().length * table.getGameTable()[0].length;

        System.out.println("How many mines do you want? 1-" + limit + " (recommended is " + ((limit / 5) + 1) + ")");
        mineCount = inputErrorCatch(limit);  // mineMaxMinLimit and string catch.
        System.out.println("Welcome " + player.getName() + ". You are playing with " + mineCount + " mines, type your first move, row and column:");

    }

    public static void gamePlay(){
        boolean gameEnded = false;
        int row;
        int column;
        String input;

        startText();
        table.fillWithMines(mineCount);
        System.out.println(table);

        do {
            //TODO: Add input check
            ioh.clearScreen();
            System.out.println(table);
            System.out.println("Move (<col><row>): ");
            input = scan.nextLine();
            row = Integer.parseInt(input.substring(1)) - 1;
            column = ioh.letterToInt(input.charAt(0));

            if (table.checkInput(row, column) == false) {
                System.out.println("Invalid input");
            }
            else {
                Square square = table.play(row, column);
                //countUncovered++; count for how many tiles are uncovered, for winning argument below
                //System.out.println(" ? uncovered: " + countUncovered);//for developing purposes, comment out if game finished
                if (square.isMine()) {
                    System.out.println("Boom!! there is a bomb");
                    gameEnded = true;
                }
                else {
                    table.decrementMarksRemaining();
                    System.out.println("Question marks remaining: " + table.getQuestionMarksRemaining());

                    if (square.getNumberOfMinesAround() == 0) {
                        table.uncoverAroundZeros(row, column);
                    }
                }
                if (table.getQuestionMarksRemaining() == mineCount) {
                    System.out.println("Yeah, you won!! You found all the mines");
                    break;
                }

                System.out.println(table);
            }
        } while (!gameEnded);
    }

    public static int inputErrorCatch(int limit) {// Catch MaxMin-mines/exception, return working mineCount.
       int mines;

        while (true) {
            try {
                mines = Integer.parseInt(scan.nextLine());  // Ask player how many mines and set it in fillWithMines()
                if (mines < 1) {
                    System.out.println("You took too few mines! Try again 1-" + limit);
                } else if (mines > limit) {
                    System.out.println("You took too many mines! Try again 1-" + limit);
                } else {
                    break;
                }
            }catch(Exception e){
                System.out.println("Error! Try again 1-" + limit + "!");
                scan.nextLine();
            }
        }
        return mines;
    }
}

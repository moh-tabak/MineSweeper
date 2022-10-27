import java.util.Scanner;

public class Game {
    static Scanner scan = new Scanner(System.in);
    static Player player = new Player();
    static GameBord table;
    static int mineCount;
    static InputOutputHelper ioh = new InputOutputHelper();

    public Game() {
        startGame();
    }

    public void startGame() {
        String playAgain = null;
        do {
            gamePlay();
            System.out.println("Do you like to play again? yes/no");
            playAgain = scan.next();
        } while(playAgain.equals("yes"));
    }
    private static void startText() {
        int limit;

        ioh.clearScreen();
        System.out.println("Welcome to MineSweeper!");
        System.out.print("What is your name? > ");
        player.setName(scan.nextLine());
        //TODO: Add error checking
        System.out.println("\nHow big should the game board be?");
        table = new GameBord(ioh.getValidInt("Rows > "), ioh.getValidInt("Columns > "));

        limit = table.getGameTable().length * table.getGameTable()[0].length;

        System.out.print("\nHow many mines do you want? 1-"
                + limit + " (recommended is " + ((limit / 5) + 1) + ") > ");
        mineCount = inputErrorCatch(limit);  // mineMaxMinLimit and string catch.
        System.out.println("\nWelcome " + player.getName() + ". You are playing with "
                + mineCount + " mines. To play type <column><row> for example E5. \nPress enter to start game!");
        scan.nextLine(); //Otherwise scanner will mess with me and stop reading.

    }

    private static void gamePlay(){
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
            System.out.println("\u23AF".repeat(table.getColumns() * 4 + 6));
            System.out.print("> ");
            input = scan.nextLine();
            row = Integer.parseInt(input.substring(1)) - 1;
            column = ioh.letterToInt(input.charAt(0));

            if (table.checkInput(row, column) == false) {
                System.out.println("Invalid input");
            }
            else {
                Square square = table.play(row, column);

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
            }
        } while (!gameEnded);
    }

    private static int inputErrorCatch(int limit) {// Catch MaxMin-mines/exception, return working mineCount.
       int mines;

        while (true) {
            try {
                // Ask player how many mines and set it in fillWithMines()
                mines = Integer.parseInt(scan.nextLine());
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

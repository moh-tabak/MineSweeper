import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    Player player = new Player();
    boolean playerTurn = true;
    int status = GameBord.NOT_DONE_YET;


    public void startText() {
        System.out.println("Welcome to MineSweeper!");
        System.out.println("What is your name?");
        player.setName(scan.nextLine());
        System.out.println("Welcome " + player.getName() + ", type your first move, row and column:");

    }

    public void gamePlay(){
        while(playerTurn){

            System.out.println("Ok " + player.getName() + ", type your next move, row and column:");
            player.setName(scan.nextLine());
            if(Square.isMineHere=true){

            }

        }

    }

    //checks if the user chose right inputs or not,
    public boolean checkInput(String row, String column){

        if (!row.equals("a") && !row.equals("b")&& !row.equals("c") && !row.equals("d")){
            return false;
        }
        else{
            if (!column.equals("1")&&!column.equals("2")&&!column.equals("3")&&!column.equals("4")&&!column.equals("5")){
                return false;
            }
        }
        return true;
    }

}

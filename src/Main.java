import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBord board = new GameBord();
        board.fillWithMines();

        board.printRevealed();  //This should be removed when development is finished

        board.print();
        Game.startText();
        Game.gamePlay();

    }
}
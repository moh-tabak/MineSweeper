import java.util.*;

public class GameBord {

    static ArrayList playerXPos = new ArrayList<>();

    public String[][] GameTable;

    public GameBord() {
        this.GameTable = new String[][]{
                {" 1 ", " 2 ", " 3 ", " 4 ", " 5 "},
                {" 6 ", " 7 ", " 8 ", " 9 ", "10 "},
                {"11 ", "12 ", "13 ", "14 ", "15 "},
                {"16 ", "17 ", "18 ", "19 ", "20 "}


        };
    }


    public void print() {

        System.out.println("  " + GameTable[0][0] + "|" + GameTable[0][1] + "|" + GameTable[0][2] + "|" + GameTable[0][3] + "|" + GameTable[0][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("  " + GameTable[1][0] + "|" + GameTable[1][1] + "|" + GameTable[1][2] + "|" + GameTable[1][3] + "|" + GameTable[1][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("  " + GameTable[2][0] + "|" + GameTable[2][1] + "|" + GameTable[2][2] + "|" + GameTable[2][3] + "|" + GameTable[2][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("  " + GameTable[3][0] + "|" + GameTable[3][1] + "|" + GameTable[3][2] + "|" + GameTable[3][3] + "|" + GameTable[3][4]);

    }

    public static void playerSymbol(String[][] GameBoard, String squarePosition, String user) {


        String symbol = "";

        if (user.equals("PlayerX")) {
            symbol = " X ";
            playerXPos.add(squarePosition);


            switch (squarePosition) {
                case "1":
                    GameBoard[0][0] = symbol;
                    break;
                case "2":
                    GameBoard[0][1] = symbol;
                    break;
                case "3":
                    GameBoard[0][2] = symbol;
                    break;
                case "4":
                    GameBoard[0][3] = symbol;
                    break;
                case "5":
                    GameBoard[0][4] = symbol;
                    break;
                case "6":
                    GameBoard[1][0] = symbol;
                    break;
                case "7":
                    GameBoard[1][1] = symbol;
                    break;
                case "8":
                    GameBoard[1][2] = symbol;
                    break;
                case "9":
                    GameBoard[1][3] = symbol;
                    break;
                case "10":
                    GameBoard[1][4] = symbol;
                    break;
                case "11":
                    GameBoard[2][0] = symbol;
                    break;
                case "12":
                    GameBoard[2][1] = symbol;
                    break;
                case "13":
                    GameBoard[2][2] = symbol;
                    break;
                case "14":
                    GameBoard[2][3] = symbol;
                    break;
                case "15":
                    GameBoard[2][4] = symbol;
                    break;
                case "16":
                    GameBoard[3][0] = symbol;
                    break;
                case "17":
                    GameBoard[3][1] = symbol;
                    break;
                case "18":
                    GameBoard[3][2] = symbol;
                case "19":
                    GameBoard[3][3] = symbol;
                case "20":
                    GameBoard[3][4] = symbol;
                default:

                    System.out.println("That is not a square!");
                    break;
            }
        }
    }
}

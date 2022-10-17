import java.util.ArrayList;

public class GameBord {

    static ArrayList playerXPos = new ArrayList<>(); // Static ArrayList that can use Int
    static ArrayList PlayerOPos = new ArrayList<>();
    private String[][] GameTable;

    public GameBord() {
        this.GameTable = new String[][]{
                {" ? ", " ? ", " ? ", " ? ", " ? "},
                {" ? ", " ? ", " ? ", " ? ", " ? "},
                {" ? ", " ? ", " ? ", " ? ", " ? "},
                {" ? ", " ? ", " ? ", " ? ", " ? "}



        };
    }





    public void print() {
        System.out.println("   1   2   3   4   5");
        System.out.println("a " +GameTable[0][0] + "|" +GameTable[0][1] + "|"+ GameTable[0][2] + "|"+ GameTable[0][3] + "|"+ GameTable[0][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("b "+ GameTable[1][0] + "|" +GameTable[1][1] + "|"+ GameTable[1][2] + "|"+ GameTable[1][3] + "|"+ GameTable[1][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("c "+GameTable[2][0] + "|" +GameTable[2][1] + "|"+ GameTable[2][2] + "|"+ GameTable[2][3] + "|"+ GameTable[2][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("d "+GameTable[3][0] + "|"+ GameTable[3][1] + "|"+ GameTable[3][2] + "|"+ GameTable[3][3] + "|"+ GameTable[3][4]);

    }

    public static void playerSymbol(String [][] GameBoard , String squarePosition, String user) {


        String symbol = "";     // Empty char for use in gameBoard that is char based.

        if (user.equals("PlayerX")) {
            symbol = "X";
            playerXPos.add(squarePosition);  // symbol get placed is the switch -> gameBoard depending on what number user press.
        } else if (user.equals("PlayerO")) {
            symbol = "O";
            PlayerOPos.add(squarePosition);
        }

        switch (squarePosition) {    // 2D Array positions via a switch.
            case "1":
                GameBoard[0][1] = symbol;    // Symbol = X or O depending on what player picking a spot.
                break;
            case "2":                          // [0][0] = first column fist row.
                GameBoard[0][3] = symbol;    // [0][1] = second column first row. jumping over char  '|' in gameBoard
                break;
            case "3":
                GameBoard[0][5] = symbol;
                break;
            case "4":
                GameBoard[2][1] = symbol;
                break;
            case "5":
                GameBoard[2][3] = symbol;
                break;
            case "6":
                GameBoard[2][5] = symbol;
                break;
            case "7":
                GameBoard[4][1] = symbol;
                break;
            case "8":
                GameBoard[4][3] = symbol;
                break;
            case "9":
                GameBoard[4][5] = symbol;
                break;
            default:
                break;
        }
    }
}

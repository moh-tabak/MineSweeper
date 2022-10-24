import java.util.Random;

public class GameBord {
    private static final int ILLEGAL_MOVE = 0;
    private static final int NOT_DONE_YET = 1;
    Random rand = new Random();
    private final Square[][] gameTable;

    public GameBord() {
        this.gameTable  = new Square[4][5];
        for(int row = 0; row < 4; row++){
            for(int column = 0; column < 5; column++){
                this.gameTable[row][column] = new Square();
            }
        }
    }

    public int move(String row, String column) {
        if (Square.isUncovered == true || SquareisMineHere == true || Square.numberOfMinesAround == true || Square.Square != ' ') {
            return ILLEGAL_MOVE;
        }
        return NOT_DONE_YET;
    }/*with this we could declare in Game within the gameplay that a move is not possible. And if the game is finished or not
    It doesn't work yet, but we could try if this works. Problem still remaining is the Static error I get everywhere. We don't want or need it to
    be static but it does have to work. Can anybody else look into it?
    */


    public Square wantedPosition(String row, String column){ // returns the position selected by the player by typing the wanted row (a-d) and the wanted column (1-5) .
        int rowInNumbers = row.charAt(0)-97; // converts the column from the letter to number (a-d) to (0-4)
        return(gameTable[rowInNumbers][Integer.parseInt(column)-1]);
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

    public Square[][] getGameTable() {
        return gameTable;
    }

    public void fillWithMines() {
        for (int i = 0; i < 7; i++) { // setting 7 mines in 7 different squares.
            int row = rand.nextInt(4);
            int column = rand.nextInt(5);
            while (gameTable[row][column].isMineHere) { // to make sure that the square randomly picked has no mine in it,
                // if there is a mine in the square, just try to find another one with no mine.
                row = rand.nextInt(4);
                column = rand.nextInt(5);
            }
            gameTable[row][column].isMineHere=true;
            //Update neighboring squares
            int rowStart,colStart,rowEnd,colEnd;
            rowStart = row > 0 ? row - 1 : row;
            rowEnd = row < 3 ? row + 1 : row;
            colStart = column > 0 ? column - 1 : column;
            colEnd = column < 4 ? column + 1  : column;
            for (int r = rowStart; r <= rowEnd; r++){
                for (int c = colStart; c <= colEnd; c++){
                    gameTable[r][c].numberOfMinesAround++;
                }
            }
        }
    }

    private String printSquare(int row, int column){
        if(!gameTable[row][column].isUncovered){
            return " ? ";
        }
        else {
            if(gameTable[row][column].isMineHere)
                return " x ";
            else
                return " " + gameTable[row][column].numberOfMinesAround + " ";
        }
    }

    public void print() {
        System.out.println("   1   2   3   4   5");
        System.out.println("a " + printSquare(0,0) + "|" + printSquare(0,1) + "|"+ printSquare(0,2) + "|"+ printSquare(0,3) + "|" + printSquare(0,4));
        System.out.println("  ---+---+---+---+---");
        System.out.println("b " + printSquare(1,0) + "|" + printSquare(1,1) + "|"+ printSquare(1,2) + "|"+ printSquare(1,3) + "|" + printSquare(1,4));
        System.out.println("  ---+---+---+---+---");
        System.out.println("c " + printSquare(2,0) + "|" + printSquare(2,1) + "|"+ printSquare(2,2) + "|"+ printSquare(2,3) + "|" + printSquare(2,4));
        System.out.println("  ---+---+---+---+---");
        System.out.println("d " + printSquare(3,0) + "|" + printSquare(3,1) + "|"+ printSquare(3,2) + "|"+ printSquare(3,3) + "|" + printSquare(3,4));
        System.out.println();
    }


    //For developing
    public void printRevealed() {
        System.out.println("   1   2   3   4   5");
        System.out.println("a " + printSquareRevealed(0,0) + "|" + printSquareRevealed(0,1) + "|"+ printSquareRevealed(0,2) + "|"+ printSquareRevealed(0,3) + "|" + printSquareRevealed(0,4));
        System.out.println("  ---+---+---+---+---");
        System.out.println("b " + printSquareRevealed(1,0) + "|" + printSquareRevealed(1,1) + "|"+ printSquareRevealed(1,2) + "|"+ printSquareRevealed(1,3) + "|" + printSquareRevealed(1,4));
        System.out.println("  ---+---+---+---+---");
        System.out.println("c " + printSquareRevealed(2,0) + "|" + printSquareRevealed(2,1) + "|"+ printSquareRevealed(2,2) + "|"+ printSquareRevealed(2,3) + "|" + printSquareRevealed(2,4));
        System.out.println("  ---+---+---+---+---");
        System.out.println("d " + printSquareRevealed(3,0) + "|" + printSquareRevealed(3,1) + "|"+ printSquareRevealed(3,2) + "|"+ printSquareRevealed(3,3) + "|" + printSquareRevealed(3,4));
        System.out.println();
    }

    //For developing
    private String printSquareRevealed(int row, int column){
        if(gameTable[row][column].isMineHere)
            return " x ";
        else
            return " " + gameTable[row][column].numberOfMinesAround + " ";
    }
}

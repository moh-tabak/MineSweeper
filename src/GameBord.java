import java.util.Random;
import java.util.stream.IntStream;

//TODO: Add clear table

public class GameBord {
    Random rand = new Random();
    private final Square[][] gameTable;
    private int rows;
    private int columns;

    public int questionMarksRemaining = 20;

    public GameBord() {
        this.gameTable  = new Square[4][5];
        for(int row = 0; row < 4; row++){
            for(int column = 0; column < 5; column++){
                this.gameTable[row][column] = new Square();
            }
        }
    }
    public GameBord(int row, int col) {
        this.gameTable = new Square[row][col];
        this.questionMarksRemaining = row * col;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                this.gameTable[r][c] = new Square(r, c);
            }
        }
        this.rows = row;
        this.columns = col;
    }

    //checks if the user chose right inputs or not,
    public boolean checkInput(int row, int column) {
        //Out of bound check
        if (row < 0 || row >= rows || column < 1 || column >= columns) {
            return false;
        }
        //Already played
        else if (gameTable[row][column].isUncovered()) {
            return false;
        }
        return true;
    }

    public void fillWithMines(int numberOfMines) {
        for (int i = 0; i < numberOfMines; i++) { // setting 7 mines in 7 different squares.
            int row = rand.nextInt(gameTable.length);
            int column = rand.nextInt(gameTable[0].length);

            System.out.println(gameTable[row][column].isMine() +  " k");

            while (gameTable[row][column].isMine()) { // to make sure that the square randomly picked has no mine in it,
                // if there is a mine in the square, just try to find another one with no mine.
                row = rand.nextInt(gameTable.length);
                column = rand.nextInt(gameTable.length);
            }
            gameTable[row][column].setMine(true);
            //Update neighboring squares
            int rowStart,colStart,rowEnd,colEnd;
            rowStart = row > 0 ? row - 1 : row;
            rowEnd = row < 3 ? row + 1 : row;
            colStart = column > 0 ? column - 1 : column;
            colEnd = column < 4 ? column + 1  : column;
            for (int r = rowStart; r <= rowEnd; r++){
                for (int c = colStart; c <= colEnd; c++){
                    gameTable[row][column].incNumberOfMinesAround();
                }
            }
        }
    }

    public Square play(int row, int column){
            getSquare(row, column).setUncovered(true);
            return getSquare(row, column);
    }

    public void uncoverAroundZeros(int row, int column){
        int rowStart,colStart,rowEnd,colEnd;
        rowStart = row > 0 ? row - 1 : row;
        rowEnd = row < 3 ? row + 1 : row;
        colStart = column > 0 ? column - 1 : column;
        colEnd = column < 4 ? column + 1  : column;
        for (int r = rowStart; r <= rowEnd; r++){
            for (int c = colStart; c <= colEnd; c++){
                if(!gameTable[r][c].isUncovered() && !gameTable[r][c].isMine()){
                    gameTable[r][c].setUncovered(true);
                    questionMarksRemaining--;
                    //when a neighbouring square is uncovered and is also a zero, uncover squares around it. (recursion)
                    if(gameTable[r][c].getNumberOfMinesAround() == 0) {
                        uncoverAroundZeros(r,c);
                    }
                }
            }
        }
    }

    //TODO: Remove hardcoded padding
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    ");
        IntStream.range(0, gameTable[0].length).forEach(x -> sb.append(" " + Character.toString(x+65)));
        sb.append("\n   \u250C" + "\u2500".repeat(gameTable[0].length * 2 + 1));
        sb.append("\u2510");
        sb.append("\n");
        for(int i = 0; i < gameTable.length; i++) {
            sb.append(String.format("%1$" + 2 + "s", i + 1));
            sb.append(" \u2502");
            for(Square square :  gameTable[i]) {
                sb.append(" " + (square.isUncovered() ? square.getNumberOfMinesAround() : "?"));
            }
            sb.append(" \u2502");
            sb.append("\n");
        }
        sb.append("   \u2514" + "\u2500".repeat(gameTable[0].length*2+1));
        sb.append("\u2518");

        return sb.toString();
    }

    //Geters and seters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Square[][] getGameTable() {
        return gameTable;
    }

    public Square getSquare(int row, int column){ // returns the position selected by the player by typing the wanted row (a-d) and the wanted column (1-5) .
        return gameTable[row][column];
    }

    public int getQuestionMarksRemaining() {
        return questionMarksRemaining;
    }

    public void decrementMarksRemaining() {
        questionMarksRemaining--;
    }
}

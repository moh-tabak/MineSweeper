public class Square {
    private int numberOfMinesAround;

    private boolean mine;

    private boolean isUncovered;


    //Coordinates could be used when passing an individual square between functions.
    //If we don't find use to it, we should remove it!

    //Vertical coordinate
    private int row;
    //Horizontal coordinate.
    private int column;



    public Square() {
        row = 0;
        column = 0;
        numberOfMinesAround = 0;
        mine = false;
        isUncovered = false;
    }

    public Square(int row, int column) {
        this.row = row;
        this.column = column;
        numberOfMinesAround = 0;
        mine = false;
        isUncovered = false;
    }

    @Override
    public String toString() {
        if (!isUncovered) {
            return "?";
        }
        else {
            if (mine)
                return "x";
            else
                return String.valueOf(numberOfMinesAround);
        }
    }

    //Getters and setters
    public int getNumberOfMinesAround() {
        return numberOfMinesAround;
    }

    public void setNumberOfMinesAround(int numberOfMinesAround) {
        this.numberOfMinesAround = numberOfMinesAround;
    }

    public void incNumberOfMinesAround() {
        numberOfMinesAround++;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isUncovered() {
        return isUncovered;
    }

    public void setUncovered(boolean uncovered) {
        isUncovered = uncovered;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
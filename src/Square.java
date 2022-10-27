public class Square {
    private int numberOfMinesAround;

    private boolean mine;

    private boolean isUncovered;

    public Square() {
        numberOfMinesAround = 0;
        mine = false;
        isUncovered = false;
    }

    @Override
    public String toString() {
        if (!isUncovered) {
            return "\033[32m\u263A\033[0m";
        }
        else {
            if (mine)
                return "x";
            else
                return numberOfMinesAround > 0 ? String.valueOf(numberOfMinesAround) : " ";
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
}
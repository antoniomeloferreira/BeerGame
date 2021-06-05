package Field;

public class Position {

    private int col;
    private int row;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    //cellSize
    public void fallDown(int distance) {
        if(this.row + distance < Field.getHeight()) {
           row += distance;
        }
    }


}

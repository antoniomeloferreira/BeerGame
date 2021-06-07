package Field;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void sideMove(int distance) {
        this.col += distance;
    }



    //cellSize
    public void fallDown(int distance) {
        if(this.row + distance < Field.getHeight()) {
           row += distance;
        }
    }

    public boolean equals(Position position){
        return (this.col == position.getCol() && this.row == position.getRow());
    }


}

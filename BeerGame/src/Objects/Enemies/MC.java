package Objects.Enemies;

import Field.Field;
import Field.Position;
import Objects.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class MC extends Enemy {

    private Picture picture;
    private boolean isCollided;

    public MC(Position position){
        super(position);
        picture = new Picture(position.colToX(position.getCol()), position.rowToY(position.getRow()), "antonio.png");
        picture.draw();
        this.isCollided = false;
    }

    @Override
    public void move() {
        picture.translate(0 ,Field.CELL_SIZE);
        super.move();
    }

    public Picture getPicture(){
        return picture;
    }

    public void isCollided(boolean isCollided){
        this.isCollided = isCollided;
    }

    public boolean getIsCollided() {
        return isCollided;
    }
}

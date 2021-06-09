package Objects.Enemies;

import Field.Field;
import Field.Position;
import Objects.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class MC extends Enemy {

    private Picture picture;
    public MC(Position position){
        super(position);
        picture = new Picture(position.colToX(), position.rowToY(), "antonio.png");
        picture.draw();
    }

    @Override
    public void move() {
        picture.translate(0 ,Field.CELL_SIZE);
        super.move();
    }

    public Picture getPicture(){
        return picture;
    }
}

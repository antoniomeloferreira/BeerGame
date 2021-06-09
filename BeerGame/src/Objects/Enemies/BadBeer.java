package Objects.Enemies;

import Field.Field;
import Field.Position;
import Objects.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BadBeer extends Enemy {

    private Picture picture;

    public BadBeer (Position position){
       super(position);
       picture = new Picture(position.colToX(), position.rowToY(), "sean.png");
       picture.draw();

    }

    @Override
    public void move() {
        picture.translate(0, Field.CELL_SIZE);
        super.move();
    }

    public Picture getPicture(){
        return picture;
    }
}

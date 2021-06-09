package Objects;

import Field.Field;
import Field.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GoodBeer implements Movable {

    private Position position;
    private Picture picture;

    public GoodBeer(Position position){
        this.position = position;
        picture = new Picture(position.colToX(), position.rowToY(), "irene.png");
        picture.draw();
    }

    @Override
    public void move(){
        picture.translate(0, Field.CELL_SIZE);
        position.fallDown(1);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public Picture getPicture(){
        return picture;
    }

}

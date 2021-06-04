package Objects;

import Field.Field;
import Field.Position;

public class GoodBeer implements Movable {

    private Position pos;

    public GoodBeer(){

        pos = new Position(0, randomCol());
    }

    @Override
    public void move(){

    }

    private int randomCol(){
        return (int) (Math.random() * Field.getWidth());
    }


}

package Objects.Enemies;

import Field.Field;
import Field.Position;
import Objects.Movable;

public class BadBeer extends Enemy {

    private Position pos;

    public BadBeer (){
        pos = new Position(0, randomCol());
    }


    private int randomCol(){
        return (int) (Math.random() * Field.getWidth());
    }
}

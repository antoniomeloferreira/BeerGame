package Objects.Enemies;

import Field.Field;
import Field.Position;
import Objects.Movable;


public class MC extends Enemy {

    private Position pos;

    public MC(){
        pos = new Position(0, randomCol()); //LEMBRAR PADDING, forma de aparecer
    }

    private int randomCol(){
        return (int) (Math.random() * Field.getWidth());
    }
}

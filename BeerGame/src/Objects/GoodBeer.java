package Objects;

import Field.Field;
import Field.Position;

public class GoodBeer implements Movable {

    private Position position;

    public GoodBeer(Position position){
        this.position = position;
    }

    @Override
    public void move(){
        position.fallDown(1);
    }

    @Override
    public Position getPosition() {
        return position;
    }


}

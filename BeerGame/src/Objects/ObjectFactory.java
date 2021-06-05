package Objects;

import Field.Field;
import Field.Position;
import Objects.Enemies.BadBeer;
import Objects.Enemies.Enemy;
import Objects.Enemies.MC;

public class ObjectFactory {

    public static Player createPlayer(){
        return new Player(new Position(Field.getHeight()-1, Field.getWidth()/2));
    }

    public static Movable createBeers () {
        return (Math.random() < 0.8 ? createGoodBeer() : createBadBeer());
    }

    public static Movable createObjects(){
        return (Math.random() < 0.7 ? createGoodBeer() : createEnemies());
    }

    private static GoodBeer createGoodBeer(){
        return new GoodBeer(new Position(0, randomCol()));
    }

    private static BadBeer createBadBeer(){
        return new BadBeer(new Position(0, randomCol()));
    }

    private static MC createMC(){
        return new MC(new Position(0, randomCol()));
    }

    private static Enemy createEnemies(){
        return (Math.random() < 0.8 ? createBadBeer() : createMC());
    }

    private static int randomCol(){
        return (int) (Math.random() * Field.getWidth());
    }

}

import Field.Field;
import Objects.Movable;
import Objects.ObjectFactory;
import Objects.Player;

public class Game {

    private Player player;
    private final int DELAY = 500;
    private ObjectList movables = new ObjectList();
    private CollisionDetector collisionDetector = new CollisionDetector();

    public void init() {
        Field.init();

        player = ObjectFactory.createPlayer();
    }


    public void start() throws InterruptedException {

        init();


        while (!player.getDead()) {


            Thread.sleep((int) (Math.random() * DELAY + 100));

            if (player.getScore() <= 50) {
                movables.add(ObjectFactory.createBeers());
            } else {
                movables.add(ObjectFactory.createObjects());
            }

            for (Movable movable : movables) {
                movable.move();
                collisionDetector.check(player, movable);

                /*if (movables.getPosition().getRow() >= Field.getRows()) {
                    movables.getPosition().setRow(0);
                }*/
            }
        }
    }

}


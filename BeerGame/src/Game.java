import Field.Field;
import Objects.Movable;
import Objects.ObjectFactory;
import Objects.Player;

public class Game {

    private Player player;
    private Movable[] movables;
    private final int DELAY = 250;
    private CollisionDetector collisionDetector;

    public void init() {
        movables = new Movable[7];
        collisionDetector = new CollisionDetector(movables);
        player = ObjectFactory.createPlayer();

        //Field.init();
    }

    private void fillArray() throws InterruptedException {
        for (int i = 0; i < movables.length; i++) {

            Thread.sleep((int) (Math.random() * DELAY));

            if (movables[i] == null) {
                if (player.getScore() <= 50) {
                    movables[i] = ObjectFactory.createBeers();
                } else {
                    movables[i] = ObjectFactory.createObjects();
                }
            }
        }
    }

    public void start() throws InterruptedException {

        init();

        while(!player.getDead()) {

            fillArray();

            for (int i = 0; i < movables.length; i++) {
                movables[i].move();
                collisionDetector.check(player);

                if (movables[i].getPosition().getRow() >= Field.getHeight()) {
                    movables[i] = null;
                }
            }
        }

    }
}

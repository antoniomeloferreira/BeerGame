import Field.Field;
import Objects.Enemies.BadBeer;
import Objects.Enemies.MC;
import Objects.GoodBeer;
import Objects.Movable;
import Objects.ObjectFactory;
import Objects.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private final int DELAY = 200;
    private ObjectList movables = new ObjectList();
    private CollisionDetector collisionDetector = new CollisionDetector();

    public void init() {
        Field.init();

        player = ObjectFactory.createPlayer();
    }


    public void start() {

        init();

        Text score = new Text(50, 20, "Score: " + player.getScore());
        score.grow(20, 10);
        score.setColor(Color.WHITE);
        score.draw();

        Picture liver1 = new Picture(670, 10, "liver.png");
        Picture liver2 = new Picture(710, 10, "liver.png");
        Picture liver3 = new Picture(750, 10, "liver.png");
        liver1.draw();
        liver2.draw();
        liver3.draw();


        while (!player.getDead()) {


            try {
                Thread.sleep(DELAY);
            } catch (Exception e) {
                System.out.println("error");
            }

            if (player.getScore() <= 50) {
                movables.add(ObjectFactory.createBeers());
            } else {
                movables.add(ObjectFactory.createObjects());
            }

            for (Movable movable : movables) {
                movable.move();
                collisionDetector.check(player, movable);
                score.setText("Score: " + player.getScore());
                if (player.getLivers() == 2) {
                    liver3.delete();
                }
                if (player.getLivers() == 1) {
                    liver2.delete();
                }
                if (player.getLivers() == 0) {
                    liver1.delete();
                }


                if (movable.getPosition().getRow() == Field.getRows() - 1 && movable instanceof MC) {
                    movable.getPicture().delete();
                    ((MC) movable).isCollided(true);
                }
                if (movable.getPosition().getRow() == Field.getRows() - 1 && movable instanceof BadBeer) {
                    movable.getPicture().delete();
                    ((BadBeer) movable).isCollided(true);
                }

                if (movable.getPosition().getRow() == Field.getRows() - 1 && movable instanceof GoodBeer) {
                    movable.getPicture().delete();
                    ((GoodBeer) movable).isCollided(true);
                }

            }

        }

        player.getPicture().delete();
        for (Movable movable : movables) {
            movable.getPicture().delete();
        }
        Text gameOver = new Text(350, 250, "GAME OVER!");
        gameOver.setColor(Color.RED);
        gameOver.grow(200, 150);
        gameOver.draw();
        score.grow(20, 10);
        score.translate(465, 350);

    }

}




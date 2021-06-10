import Field.Field;
import Objects.Movable;
import Objects.ObjectFactory;
import Objects.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {

    private Player player;
    private final int DELAY = 2500;
    private ObjectList movables = new ObjectList();
    private CollisionDetector collisionDetector = new CollisionDetector();

    public void init() {
        Field.init();

        player = ObjectFactory.createPlayer();
    }


    public void start() {

        init();

        Text score = new Text(50, 30, "Score: " + player.getScore());
        score.grow(20, 20);
        score.setColor(Color.GREEN);
        score.draw();

        Text livers = new Text(700, 30, "Livers: " + player.getLivers());
        livers.grow(20, 20);
        livers.setColor(Color.PINK);
        livers.draw();

        while (!player.getDead()) {


            try{
                Thread.sleep((int) (Math.random() * DELAY + 100));
            } catch (Exception e){
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
                livers.setText("Livers: " + player.getLivers());

                if(movable.getPosition().getRow() == Field.getRows()-1){
                    movable.getPicture().delete();
                }
            }
        }
    }

}


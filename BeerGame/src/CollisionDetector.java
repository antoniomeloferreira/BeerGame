import Objects.Enemies.BadBeer;
import Objects.Enemies.MC;
import Objects.GoodBeer;
import Objects.Movable;
import Objects.Player;

public class CollisionDetector {

    private Movable[] gameObjects;

    public CollisionDetector(Movable[] gameObjects){
        this.gameObjects = gameObjects;
    }

    public void check(Player player){

        for(Movable obj : gameObjects) {

            if (player.getPosition().equals(obj.getPosition())) {

                if (obj instanceof MC) {
                    player.loseLivers();
                }

                /*if (obj instanceof BadBeer) {

                }*/

                if (obj instanceof GoodBeer) {
                    player.setScore(5);
                }
            }
        }
    }
}

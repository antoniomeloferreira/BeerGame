import Objects.Enemies.BadBeer;
import Objects.Enemies.MC;
import Objects.GoodBeer;
import Objects.Movable;
import Objects.Player;

import java.util.LinkedList;

public class CollisionDetector {


    public void check(Player player, Movable obj) {


        if (player.getPosition().equals(obj.getPosition())) {

            if (obj instanceof MC) {
                if (!((MC) obj).getIsCollided()) {
                    ((MC) obj).isCollided(true);
                    player.loseLivers();
                    ((MC) obj).getPicture().delete();
                    obj = null;
                }
            }

            if (obj instanceof BadBeer) {
                if (!((BadBeer) obj).getIsCollided()) {
                    ((BadBeer) obj).isCollided(true);
                    if (player.isSwitchedKeyboard()) {
                        player.setSwitchedKeyboard(false);
                        ((BadBeer) obj).getPicture().delete();
                        obj = null;

                    } else {
                        player.setSwitchedKeyboard(true);
                        ((BadBeer) obj).getPicture().delete();
                        obj = null;
                    }
                }
            }

            if (obj instanceof GoodBeer) {
                if (!((GoodBeer) obj).getIsCollided()) {
                    ((GoodBeer) obj).isCollided(true);
                    player.setScore(5);
                    ((GoodBeer) obj).getPicture().delete();
                     obj = null;
                }
            }
        }
    }
}


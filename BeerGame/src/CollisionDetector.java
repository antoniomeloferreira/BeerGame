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
                player.loseLivers();
                ((MC) obj).getPicture().delete();
                System.out.println(player.getLivers());
            }

            if (obj instanceof BadBeer) {
                if (player.isSwitchedKeyboard()) {
                    player.setSwitchedKeyboard(false);
                    ((BadBeer) obj).getPicture().delete();
                    obj = null;
                    System.out.println("Apanhei Sean Troquei para false");

                } else {
                    player.setSwitchedKeyboard(true);
                    ((BadBeer) obj).getPicture().delete();
                    obj = null;
                    System.out.println("Apanhei Sean Troquei para true");
                }
            }

            if (obj instanceof GoodBeer) {
                player.setScore(5);
                ((GoodBeer) obj).getPicture().delete();
                System.out.println("Apanhei irene" + player.getScore());
            }
        }
    }
}


package Objects;

import Field.Position;
import Objects.Movable;

public class Player implements Movable {

    private int livers;
    private int score;
    private boolean isDead;
    private Position position;

    public Player(Position position) {
        livers = 3;
        score = 0;
        isDead = false;
        this.position = position;
    }

    @Override
    public void move() {

    }

    public void setDead() {
        isDead = true;
    }

    public boolean getDead() {
        return isDead;
    }

    public int getLivers() {
        return livers;
    }

    public void loseLivers() {
        livers--;
        if(livers  == 0){
            setDead();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    @Override
    public Position getPosition(){
        return position;
    }




}

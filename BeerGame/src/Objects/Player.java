package Objects;

import Field.Field;
import Field.Position;
import Objects.Movable;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.pictures.*;

public class Player implements Movable, KeyboardHandler {

    private int livers;
    private int score;
    private boolean isDead;
    private Position position;
    private Picture picture;
    private boolean switchedKeyboard;


    public Player(Position position) {
        livers = 3;
        score = 0;
        isDead = false;
        this.position = position;
        switchedKeyboard = false;
        keyboardInit();
        picture = new Picture(position.colToX(), position.rowToY(), "stallman.png");
        picture.draw();
    }

    private void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (!switchedKeyboard) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    if (!(getPosition().getCol() == Field.getCols() - 1)) {
                        picture.translate(Field.CELL_SIZE, 0);
                        position.sideMove(1);
                    }
                    break;

                case KeyboardEvent.KEY_LEFT:
                    if (!(getPosition().getCol() == 0)) {
                        picture.translate(-Field.CELL_SIZE, 0);
                        position.sideMove(-1);
                    }
                    break;
            }
        } else {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_LEFT:
                    if (!(getPosition().getCol() == Field.getCols() - 1)) {
                        picture.translate(Field.CELL_SIZE, 0);
                        position.sideMove(1);
                    }
                    break;

                case KeyboardEvent.KEY_RIGHT:
                    if (!(getPosition().getCol() == 0)) {
                        picture.translate(-Field.CELL_SIZE, 0);
                        position.sideMove(-1);
                    }
                    break;

            }

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
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
        if (livers == 0) {
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
    public Position getPosition() {
        return position;
    }

    public void setSwitchedKeyboard(boolean trade) {
        switchedKeyboard = trade;
    }

    public boolean isSwitchedKeyboard() {
        return switchedKeyboard;
    }
}

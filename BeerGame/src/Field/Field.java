package Field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private static int width;
    private static int height;
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 75;

    //init()
    public static void init() {
        //Picture background = new Picture(PADDING, CELL_SIZE, "beerground.jpeg");
        Rectangle background = new Rectangle(PADDING, PADDING, 800, 900);
        width = background.getWidth();
        height = background.getHeight();
        //background.grow(100, 100);
        background.draw();
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight() {
        return height;
    }
}


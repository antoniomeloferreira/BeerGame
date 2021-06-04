package Field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private static int width;
    private static int height;
    public static final int PADDING = 10;

    //init()
    public static void init() {
        Picture background = new Picture(PADDING, PADDING, "beerground.jpeg");
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


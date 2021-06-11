import Field.Field;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.*;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class MainMenu implements KeyboardHandler {

    public static final int PADDING = 10;
    private Text[] menuOptions = new Text[3];
    private Text[] helpTexts = new Text[6];
    private boolean isHelpText = false;
    private boolean threadRunning = false;


    private void isThreadRunning() {
        if (threadRunning) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    game = new Game();
                    game.init();
                }
            });
            thread.start();
        }
        else{
            game.stop();
            MainMenu mainMenu = new MainMenu();
            mainMenu.init();
        }
    }

        private void setThreadRunning(Boolean run){
            threadRunning = run;
        }

        private Game game;

        KeyboardEvent upPressed;
        KeyboardEvent spacePressed;
        KeyboardEvent downPressed;
        KeyboardEvent qPressed;
        Keyboard keyboard;

        Picture menuBg;


        public void init () {
            menuBg = new Picture(PADDING, PADDING, "bar1.png");
            menuBg.draw();
            initMenuOptions();
            drawOptions(menuOptions);
            keyboardInit();
            initHelpTexts();
            game = new Game();
        }


        public void initMenuOptions () {
            menuOptions[0] = new Text(150, 140, "PLAY");
            menuOptions[0].setColor(Color.RED);
            menuOptions[1] = new Text(150, 220, "HELP");
            menuOptions[2] = new Text(150, 300, "QUIT");
            for (Text option : menuOptions) {
                option.grow(20, 20);
            }
        }

        public void initHelpTexts () {
            helpTexts[0] = new Text(88, 90, "Catch <BEERS> to increase your score.");
            helpTexts[1] = new Text(88, 135, "Be careful! Some beers may have some");
            helpTexts[2] = new Text(88, 180, "<UNDESIRED> effects, but as they say");
            helpTexts[3] = new Text(88, 225, "\"LIKE <CURES> LIKE\"...  Also, don't let");
            helpTexts[4] = new Text(88, 270, "the <MCS> see you drinking, otherwise");
            helpTexts[5] = new Text(88, 315, "you lose a <LIVER>. GOOD CODEBREAK!");
            for (Text helps : helpTexts) {
                helps.grow(58, 13);
            }
        }

        public void drawOptions (Text[]menuOptions){
            for (Text option : menuOptions) {
                option.draw();
            }
        }

        public void deleteOptions (Text[]menuOptions){
            for (Text options : menuOptions) {
                options.delete();
            }
        }

        public void drawHelpText (Text[]helpTexts){
            for (Text helps : helpTexts) {
                helps.draw();
            }
        }

        public void deleteHelpText (Text[]helpTexts){
            for (Text helps : helpTexts) {
                helps.delete();
            }
        }

        public void keyboardInit () {
            keyboard = new Keyboard(this);

            downPressed = new KeyboardEvent();
            downPressed.setKey(KeyboardEvent.KEY_DOWN);
            downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            upPressed = new KeyboardEvent();
            upPressed.setKey(KeyboardEvent.KEY_UP);
            upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            spacePressed = new KeyboardEvent();
            spacePressed.setKey(KeyboardEvent.KEY_SPACE);
            spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            qPressed = new KeyboardEvent();
            qPressed.setKey(KeyboardEvent.KEY_Q);
            qPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            keyboard.addEventListener(upPressed);
            keyboard.addEventListener(downPressed);
            keyboard.addEventListener(spacePressed);
            keyboard.addEventListener(qPressed);
        }

        @Override
        public void keyPressed (KeyboardEvent keyboardEvent){

            switch (keyboardEvent.getKey()) {

                case KeyboardEvent.KEY_DOWN:
                    if (menuOptions[1].getColor() == Color.RED) {
                        menuOptions[1].setColor(Color.BLACK);
                        menuOptions[2].setColor(Color.RED);

                    } else if (menuOptions[0].getColor() == Color.RED) {
                        menuOptions[0].setColor(Color.BLACK);
                        menuOptions[1].setColor(Color.RED);

                    } else if (menuOptions[2].getColor() == Color.RED) {
                        menuOptions[2].setColor(Color.BLACK);
                        menuOptions[0].setColor(Color.RED);

                    }
                    break;

                case KeyboardEvent.KEY_UP:
                    if (menuOptions[1].getColor() == Color.RED) {
                        menuOptions[1].setColor(Color.BLACK);
                        menuOptions[0].setColor(Color.RED);

                    } else if (menuOptions[0].getColor() == Color.RED) {
                        menuOptions[0].setColor(Color.BLACK);
                        menuOptions[2].setColor(Color.RED);

                    } else if (menuOptions[2].getColor() == Color.RED) {
                        menuOptions[2].setColor(Color.BLACK);
                        menuOptions[1].setColor(Color.RED);

                    }
                    break;


                case KeyboardEvent.KEY_SPACE:
                    if (menuOptions[0].getColor() == Color.RED) {
                        keyboard.removeEventListener(spacePressed);
                        keyboard.removeEventListener(upPressed);
                        keyboard.removeEventListener(downPressed);
                        game = new Game();
                        //game.init();
                        setThreadRunning(true);
                        isThreadRunning();
                        break;
                    }
                    if (menuOptions[1].getColor() == Color.RED) {
                        isHelpText = true;
                        keyboard.removeEventListener(spacePressed);
                        keyboard.removeEventListener(upPressed);
                        keyboard.removeEventListener(downPressed);
                        deleteOptions(menuOptions);
                        drawHelpText(helpTexts);
                        break;
                    }
                    if (menuOptions[2].getColor() == Color.RED) {
                        System.exit(0);
                        break;
                    }
                    break;


                case KeyboardEvent.KEY_Q:

                    if (menuOptions[0].getColor() == Color.RED) {
                        if (game.isGameOn()) {
                            setThreadRunning(false);
                            isThreadRunning();
                            keyboard.addEventListener(spacePressed);
                            keyboard.addEventListener(upPressed);
                            keyboard.addEventListener(downPressed);
                            break;
                        } else {
                            menuOptions[2].setColor(Color.RED);
                            menuOptions[0].setColor(Color.BLACK);
                            menuOptions[1].setColor(Color.BLACK);
                            break;
                        }
                    }

                    if (menuOptions[1].getColor() == Color.RED) {
                        if (isHelpText == true) {
                            isHelpText = false;
                            deleteHelpText(helpTexts);
                            drawOptions(menuOptions);
                            keyboard.addEventListener(spacePressed);
                            keyboard.addEventListener(upPressed);
                            keyboard.addEventListener(downPressed);
                            break;
                        } else {
                            menuOptions[2].setColor(Color.RED);
                            menuOptions[0].setColor(Color.BLACK);
                            menuOptions[1].setColor(Color.BLACK);
                            break;
                        }
                    }

                    if (menuOptions[2].getColor() == Color.RED) {
                        System.exit(0);
                        break;
                    }
                    break;

                default:
                    break;
            }

        }


        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }

    }



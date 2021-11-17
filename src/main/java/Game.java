import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    private Arena arena = new Arena(WIDTH, HEIGHT);

    public Game() throws IOException {

            TerminalSize terminalSize = new TerminalSize(WIDTH, HEIGHT);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
    }
    private void draw() throws IOException {

        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();

    }
    public void run() throws IOException{

        KeyStroke key;

        do {

            draw();
            key = screen.readInput();
            processKey(key);

        } while (key.getKeyType() != KeyType.EOF && !(key.getCharacter() != null && key.getCharacter() == 'q') && !(arena.isCtrl()));

        screen.clear();

        TextGraphics graph = screen.newTextGraphics();
        graph.putString(45, 9, "YOU WON!");

        screen.refresh();
        screen.readInput();
        screen.close();

    }
    private void processKey(KeyStroke key) {

        arena.processKey(key);

    }
}
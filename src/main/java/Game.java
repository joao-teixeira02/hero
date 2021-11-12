import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    private Arena arena = new Arena(100, 50);

    public Game() throws IOException {

            TerminalSize terminalSize = new TerminalSize(100, 50);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
    }
    private void draw() throws IOException {

        screen.clear();
        arena.draw(screen);
        screen.refresh();

    }
    public void run() throws IOException{

        KeyStroke key;

        do {

            draw();
            key = screen.readInput();
            processKey(key);

        } while (key.getKeyType() != KeyType.EOF && !(key.getCharacter() != null && key.getCharacter() == 'q'));

        screen.close();

    }
    private void processKey(KeyStroke key) {

        arena.processKey(key);

    }
}
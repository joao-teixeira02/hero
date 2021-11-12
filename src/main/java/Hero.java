import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private Position pos;

    public Hero(Position position) {

        pos = position;

    }
    public void draw_h(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "X");

    }
    public void setPosition(Position pos) {

        this.pos = pos;

    }
    public Position moveUp() {

        return new Position(pos.getX(), pos.getY() - 1);

    }
    public Position moveDown() {

        return new Position(pos.getX(), pos.getY() + 1);

    }
    public Position moveLeft() {

        return new Position(pos.getX() - 1, pos.getY());

    }
    public Position moveRight(){

        return new Position(pos.getX() + 1, pos.getY());

    }
}
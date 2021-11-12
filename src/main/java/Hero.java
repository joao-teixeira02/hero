import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private Position pos;

    public Hero(Position position) {

        pos = position;

    }
    public void draw_h(Screen screen) {

        screen.setCharacter(pos.getX(), pos.getY(), TextCharacter.fromCharacter('X')[0]);

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
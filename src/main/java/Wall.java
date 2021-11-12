import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private Position pos;

    public Wall(int x, int y) {

        pos = new Position(x, y);

    }
    public Position getPosition(){

        return pos;

    }
    public int getX(){

        return pos.getX();

    }
    public int getY(){

        return pos.getY();

    }
    public void draw(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "M");

    }
}
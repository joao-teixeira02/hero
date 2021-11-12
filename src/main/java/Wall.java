import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private int x;
    private int y;

    public Wall(int x, int y) {

        this.x = x;
        this.y = y;

    }
    public int getX() {

        return x;

    }
    public int getY() {

        return y;

    }
    public void draw(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.putString(new TerminalPosition(x, y), "M");

    }
}
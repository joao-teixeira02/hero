import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {

    public Monster(int x, int y) {
        super(x, y);
    }
    public Position move() {
        int r = (int) (Math.random() * (5 - 1)) + 1;

        if (r == 1) {
            Position position = new Position(pos.getX(), pos.getY() - 1);
            return position;
        }
        else if (r == 2) {
            Position position = new Position(pos.getX(), pos.getY() + 1);
            return position;
        }
        else if (r == 3) {
            Position position = new Position(pos.getX() - 1, pos.getY());
            return position;
        }
        else{
            Position position = new Position(pos.getX() + 1, pos.getY());
            return position;
        }
    }
    public void draw(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "M");

    }
}

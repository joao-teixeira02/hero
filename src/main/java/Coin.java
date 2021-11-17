import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{

    public Coin(int x, int y) {

        super(x, y);

    }
    public void draw(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "O");

    }
    public boolean land(Position position) {
        return pos.getX() == position.getX() && pos.getY() == position.getY();
    }
}

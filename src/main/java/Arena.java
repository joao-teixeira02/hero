import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class Arena {

    private int width;
    private int height;
    private Position pos = new Position(10,10);
    private Hero hero = new Hero(pos);

    public Arena(int w, int h) {

        width = w;
        height = h;

    }
    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        hero.draw_h(graphics);

    }
    private void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }
    public boolean canHeroMove(Position pos) {

        if (pos.getX() >= width || pos.getX() < 0) {

            return false;

        }
        else if (pos.getY() >= height || pos.getY() < 0) {

            return false;

        }
        return true;
    }
    public void processKey(KeyStroke key) {

        System.out.println(key);


        switch (key.getKeyType()) {

            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;

        }

    }
}

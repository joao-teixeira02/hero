import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class Arena {

    private int width;
    private int height;
    private Position pos = new Position(10,10);
    private Hero hero = new Hero(pos);
    private List<Wall> walls;

    public Arena(int w, int h) {

        width = w;
        height = h;
        this.walls = createWalls();

    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;

    }
    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : walls)
            wall.draw(graphics);

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
        for (Wall wall:walls) {

            if(wall.getPosition().equals(pos)) {

                return false;

            }
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

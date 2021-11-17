import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;
    private int height;
    private Hero hero = new Hero(10, 10);
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private Integer scr = 0;
    public boolean ctrl = false;

    public Arena(int w, int h) {

        width = w;
        height = h;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();

    }
    public boolean isCtrl() {
        return ctrl;
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
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Coin coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

            while (!(coin.check(hero.getX(), hero.getY()) || coin.check(coins.get(i).getX(), coins.get(i).getY()))) {

                //while the coin is not in a valid position, we will keep generating new ones until it is

                coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            }
            coins.add(coin);
        }
        return coins;
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        List<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Monster monster = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

            while (!(monster.check(hero.getX(), hero.getY()))) {

                //while the coin is not in a valid position, we will keep generating new ones until it is

                monster = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            }
            monsters.add(monster);
        }
        return monsters;
    }
    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : walls)
            wall.draw(graphics);

        for (Coin coin : coins) {
            coin.draw(graphics);
        }
        for (Monster monster : monsters) {
            monster.draw(graphics);
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(45, 0, "Score: " + scr.toString());
        hero.draw_h(graphics);

    }
    private void moveHero(Position position) {
        if (canEntityMove(position)) {
            hero.setPosition(position);
            verifyMonsterCollisions();
            retrieveCoins();
            if (coins.size() == 0) {
                ctrl = true;
            }
            moveMonsters();
            verifyMonsterCollisions();
        }
    }
    public void moveMonsters() {
        for (Monster monster : monsters) {
            Position position = monster.move();
            if (canEntityMove(position)) monster.setPos(position);
        }
    }
    public void retrieveCoins() {

        for (Coin coin : coins) {
            if (coin.land(hero.getPosition())) {
                scr ++;
                coins.remove(coin);
                break;
            }
        }
    }
    public void verifyMonsterCollisions() {
        for (Monster monster : monsters) {
            if (hero.getPosition().equals(monster.getPosition())) {
                System.exit(0);
            }
        }
    }
    public boolean canEntityMove(Position pos) {

        if (pos.getX() >= width || pos.getX() < 0) {
            return false;
        }
        if (pos.getY() >= height || pos.getY() < 0) {
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

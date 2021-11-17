public abstract class Element {

    protected Position pos;

    public Element(int x, int y) {

        pos = new Position(x, y);

    }
    public int getX(){

        return pos.getX();

    }
    public int getY(){

        return pos.getY();

    }
    public Position getPosition(){

        return pos;

    }
    public void setPos(Position position) {
        pos = position;
    }
    public boolean check(int x, int y) {
        return pos.getX() != x || pos.getY() != y;
    }
}

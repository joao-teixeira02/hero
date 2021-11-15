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
}

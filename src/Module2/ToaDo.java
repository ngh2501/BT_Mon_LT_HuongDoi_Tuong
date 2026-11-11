package Module2;

public class ToaDo {
    private int x;
    private int y;
    private String name;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToaDo(int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public ToaDo() {
        this.name = "Chua co ten";
        this.x = 0;
        this.y = 0;
    }

    public String toString() {
        return String.format("%s(%d,%d)", this.name, this.x, this.y);
    }
}
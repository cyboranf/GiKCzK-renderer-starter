package CGlab;

public class Vec2f {
    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float x;
    public float y;
    @Override
    public String toString() {
        return x + " " + y;
    }
}

package Frog;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() { position = 5; }

    public int getPosition(int position) {
        return this.position = position;
    }

    public boolean jump(int steps) {
        if (((position + steps) > MAX_POSITION) || ((position + steps) < MIN_POSITION)){
            return false;
        }
        return true;
    }
}

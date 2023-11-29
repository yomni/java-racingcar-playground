package domain.policy;

public class Stop implements CarMovePolicy {
    private static final int STOP = 0;

    @Override
    public int move() {
        return STOP;
    }
}

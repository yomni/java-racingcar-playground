package domain.policy;

public class Move implements CarMovePolicy {
    private static final int MOVE = 1;

    @Override
    public int move() {
        return MOVE;
    }
}

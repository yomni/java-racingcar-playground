package domain.policy;

import java.util.Random;

public class RandomCarMovePolicy implements CarMovePolicy {
    private static final int MOVE = 1;
    private static final int STOP = 0;
    private static final int MOVE_BASE_VALUE = 4;

    @Override
    public int move() {
        Random random = new Random();
        int randomValue = random.nextInt(10);

        return randomValue >= MOVE_BASE_VALUE ? MOVE : STOP;
    }
}

package domain;

import domain.policy.CarMovePolicy;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 0;
    private static final String INVALID_WHEN_CAR_NAME_LENGTH = "자동차 이름 길이는 " + CAR_NAME_MIN_LENGTH + " 자 초과 " + CAR_NAME_MIN_LENGTH + "자 미만이어야 합니다.";
    private String name;
    private int position;

    public Car(String name) {
        validationNameLength(name);
        this.name = name;
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    private void validationNameLength(String name) {
        if (null == name || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_WHEN_CAR_NAME_LENGTH);
        }

        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_WHEN_CAR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(CarMovePolicy carMovePolicy) {
        this.position += carMovePolicy.move();
    }
}

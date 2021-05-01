package com.nextstep.precourse;

public class Car implements Cloneable {
	public static final int RANDOM_MAXIMUM_NUMBER = 9;
	public static final int MOVING_CRITERIA = 3;

	private String name;
	private int distance = 0;
	private int tryCount = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	public int getTryCount() {
		return tryCount;
	}

	public int tryToMove() {
		tryCount++;
		int randomNumber = RandomNumberGenerator.getRandomNumber(RANDOM_MAXIMUM_NUMBER);
		if (isPossibleToMove(randomNumber)) {
			return distance++;
		}
		return distance;
	}

	public boolean isPossibleToMove(int criteriaNumber) {
		return criteriaNumber > MOVING_CRITERIA;
	}

	@Override
	protected Car clone() throws CloneNotSupportedException {
		return (Car)super.clone();
	}
}

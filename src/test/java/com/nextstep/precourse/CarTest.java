package com.nextstep.precourse;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	private static Car testCar;

	@BeforeAll
	public static void createTestCar() {
		testCar = new Car("TestCar");
	}

	@ParameterizedTest
	@ValueSource(strings = {"car1", "car2"})
	public void getName(String name) {
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	public void tryToMoveDistance() {
		int currentDistance = testCar.getDistance();
		testCar.tryToMove();
		assertThat(testCar.getDistance())
			.isBetween(currentDistance, currentDistance + 1);
	}

	@Test
	public void tryToMoveCount() {
		int currentDistance = testCar.getTryCount();
		testCar.tryToMove();
		assertThat(testCar.getTryCount())
			.isEqualTo(currentDistance + 1);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 3, 4, 9})
	public void isPossibleToMove(int number) {
		assertThat(testCar.isPossibleToMove(number))
			.isEqualTo(number > Car.MOVING_CRITERIA);
	}
}

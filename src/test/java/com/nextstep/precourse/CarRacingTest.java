package com.nextstep.precourse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRacingTest {
	private static int TEST_TRY_COUNT = 5;
	private static String[] TEST_CAR_NAMES = {"poby", "crong", "honux"};

	private CarRacing carRacing;

	@BeforeEach
	public void createCarRacing() {
		carRacing = new CarRacing(TEST_TRY_COUNT, TEST_CAR_NAMES);
	}

	@Test
	private void testStartRacing() {
		carRacing.startRacing();
		CarStorage carStroage = carRacing.getCarStorage();
		for (Car car : carStroage.getCars()) {
			assertEquals(car.getTryCount(), TEST_TRY_COUNT);
		}
	}
}

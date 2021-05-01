package com.nextstep.precourse;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarStorageTest {
	private static final String[] TEST_CAR_NAMES = new String[] {"pobi", "crong", "honux"};
	private CarStorage testCarStorage;

	@BeforeEach
	public void createTestCarStorage() {
		testCarStorage = new CarStorage(Arrays.asList(TEST_CAR_NAMES));
	}

	@Test
	public void testCreatedCar() {
		List<String> createdCarNames = new ArrayList<>();
		for (Car car : testCarStorage.getCars()) {
			createdCarNames.add(car.getName());
		}
		assertThat(createdCarNames)
			.containsExactly(TEST_CAR_NAMES);
	}

	@Test
	public void testMoveCars() {
		testCarStorage.moveCars();

		assertThat(testCarStorage.getCars())
			.extracting("tryCount").containsExactly(1, 1, 1);
	}

	@Test
	public void testGetFarthestMovedCarNames() {
		for (int i = 0; i < 10; i++) {
			testCarStorage.moveCars();
		}
		Car[] cars = testCarStorage.getCars();
		int farthestDistance = getFarthesDistance(cars);

		assertThat(cars)
			.filteredOn(car -> car.getDistance() == farthestDistance)
			.extracting("name")
			.containsAll(testCarStorage.getFarthestMovedCarNames());
	}

	private int getFarthesDistance(Car[] cars) {
		int farthestDistance = 0;
		for (Car car : cars) {
			farthestDistance = car.getDistance() > farthestDistance ? car.getDistance() : farthestDistance;
		}
		return farthestDistance;
	}
}

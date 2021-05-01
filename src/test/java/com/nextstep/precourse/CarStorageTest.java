package com.nextstep.precourse;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarStorageTest {
	@Test
	public void testCreatedCar() {
		String[] carNames = new String[] {"pobi", "crong", "honux"};
		CarStorage carStorage = new CarStorage(Arrays.asList(carNames));

		List<String> createdCarNames = new ArrayList<>();
		Iterator<Car> iter = carStorage.iterator();
		while (iter.hasNext()) {
			createdCarNames.add(iter.next().getName());
		}

		assertThat(createdCarNames)
			.containsExactly(carNames);
	}
}

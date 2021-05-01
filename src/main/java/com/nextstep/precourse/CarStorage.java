package com.nextstep.precourse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CarStorage implements Iterable<Car> {
	private List<Car> racingCars;

	public CarStorage(Collection<String> carNameList) {
		racingCars = new ArrayList<>();
		for (String carName : carNameList) {
			makeAndKeepNewCar(carName);
		}
	}

	private void makeAndKeepNewCar(String name) {
		Car car = new Car(name);
		racingCars.add(car);
	}

	@Override
	public Iterator<Car> iterator() {
		return racingCars.iterator();
	}
}

package com.nextstep.precourse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarStorage {
	public List<Car> racingCars;

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

	public void moveCars() {
		for (Car car : racingCars) {
			car.tryToMove();
		}
	}

	public Car[] getCars() {
		Car[] cars = new Car[racingCars.size()];
		for (int i = 0; i < racingCars.size(); i++) {
			try {
				cars[i] = racingCars.get(i).clone();
			} catch (CloneNotSupportedException e) {
				continue;
			}
		}
		return cars;
	}

	public Collection<String> getFarthestMovedCarNames() {
		int farthestDistance = 0;
		Map<Integer, List<String>> distanceMap = new HashMap<>();
		for (Car car : racingCars) {
			distanceMap.computeIfAbsent(car.getDistance(),
				key -> new ArrayList<String>()).add(car.getName());
			farthestDistance = car.getDistance() > farthestDistance ? car.getDistance() : farthestDistance;
		}
		return distanceMap.get(farthestDistance);
	}
}
